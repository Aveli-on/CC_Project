package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.ExpansionRequest;
import by.Savelii.pp.catalogService.dto.ExpansionResponse;
import by.Savelii.pp.catalogService.repository.ExpansionRepository;
import by.Savelii.pp.catalogService.repository.entity.Expansion;
import by.Savelii.pp.catalogService.service.mappers.ExpansionMapper;
import by.Savelii.pp.core.ComponentType;
import by.Savelii.pp.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional(readOnly = true)
public class ExpansionService {
    private final ExpansionRepository expansionRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(ExpansionService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public ExpansionService(ExpansionRepository expansionRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.expansionRepository = expansionRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public ExpansionResponse create(ExpansionRequest expansionRequest) {
        Optional<Expansion> expansion= expansionRepository.findByBrandAndModel(expansionRequest.getBrand(),expansionRequest.getModel());
        if(expansion.isPresent()){
            LOGGER.info("Expansion {} {} exist",expansionRequest.getBrand(),expansionRequest.getModel());
        }else {
            Expansion newExpansion = ExpansionMapper.toEntity(expansionRequest);
            Expansion save = expansionRepository.save(newExpansion);
            expansion=Optional.of(save);
            LOGGER.info("Expansion created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.EXPANSION_CARD, ExpansionMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (EX): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (EX): {}", result.getRecordMetadata());
                }
            });
        }

        return ExpansionMapper.toResponse(expansion.get());
    }
    @Transactional
    public ExpansionResponse updateById(Long id,ExpansionRequest expansionRequest) {
        Optional<Expansion> optionalExpansion = expansionRepository.findById(id);
        if(optionalExpansion.isEmpty()){
            LOGGER.error("Request for update expansion was failed, id : {} ", id);
            throw new IllegalStateException("Expansion with id "+id+" not exist");
        }
        ExpansionMapper.toUpdateEntity(optionalExpansion.get(),expansionRequest);
        expansionRepository.save(optionalExpansion.get());
        LOGGER.info("Request for update expansion success, id : {} ", id);
        return ExpansionMapper.toResponse(optionalExpansion.get());
    }
    public ExpansionResponse getById(Long id) {
        Optional<Expansion> optionalExpansion = expansionRepository.findById(id);
        if(optionalExpansion.isEmpty()){
            LOGGER.error("Request for get expansion was failed, id : {} ", id);
            throw new IllegalStateException("Expansion with id "+id+" not exist");
        }
        LOGGER.info("Request for get expansion success, id : {} ", id);
        return ExpansionMapper.toResponse(optionalExpansion.get());
    }

    public List<ExpansionResponse> getAll(){
        return expansionRepository.findAll().stream().map(ExpansionMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Expansion> optionalExpansion = expansionRepository.findById(id);
        if(optionalExpansion.isEmpty()){
            LOGGER.error("Request for delete expansion was failed, id : {} ", id);
            throw new IllegalStateException("Expansion with id "+id+" not exist");
        }
        LOGGER.info("Request for delete expansion success, id : {} ", id);
        expansionRepository.deleteById(id);
    }
}
