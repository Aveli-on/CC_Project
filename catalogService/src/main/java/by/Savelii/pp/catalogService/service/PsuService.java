package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.PsuRequest;
import by.Savelii.pp.catalogService.dto.PsuResponse;
import by.Savelii.pp.catalogService.repository.PsuRepository;
import by.Savelii.pp.catalogService.repository.entity.Psu;
import by.Savelii.pp.catalogService.service.mappers.PsuMapper;
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
public class PsuService {
    private final PsuRepository psuRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(PsuService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public PsuService(PsuRepository psuRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.psuRepository = psuRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public PsuResponse create(PsuRequest psuRequest) {
        Optional<Psu> psu= psuRepository.findByBrandAndModel(psuRequest.getBrand(),psuRequest.getModel());
        if(psu.isPresent()){
            LOGGER.info("Psu {} {} exist",psuRequest.getBrand(),psuRequest.getModel());
        }else {
            Psu newPsu = PsuMapper.toEntity(psuRequest);
            Psu save = psuRepository.save(newPsu);
            psu=Optional.of(save);
            LOGGER.info("Psu created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(),
                    new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.PSU, PsuMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (Ps): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (Ps): {}", result.getRecordMetadata());
                }
            });
        }

        return PsuMapper.toResponse(psu.get());
    }
    @Transactional
    public PsuResponse updateById(Long id,PsuRequest psuRequest) {
        Optional<Psu> optionalPsu = psuRepository.findById(id);
        if(optionalPsu.isEmpty()){
            LOGGER.error("Request for update psu was failed, id : {} ", id);
            throw new IllegalStateException("Psu with id "+id+" not exist");
        }
        PsuMapper.toUpdateEntity(optionalPsu.get(),psuRequest);
        psuRepository.save(optionalPsu.get());
        LOGGER.info("Request for update psu success, id : {} ", id);
        return PsuMapper.toResponse(optionalPsu.get());
    }
    public PsuResponse getById(Long id) {
        Optional<Psu> optionalPsu = psuRepository.findById(id);
        if(optionalPsu.isEmpty()){
            LOGGER.error("Request for get psu was failed, id : {} ", id);
            throw new IllegalStateException("Psu with id "+id+" not exist");
        }
        LOGGER.info("Request for get psu success, id : {} ", id);
        return PsuMapper.toResponse(optionalPsu.get());
    }

    public List<PsuResponse> getAll(){
        return psuRepository.findAll().stream().map(PsuMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Psu> optionalPsu = psuRepository.findById(id);
        if(optionalPsu.isEmpty()){
            LOGGER.error("Request for delete psu was failed, id : {} ", id);
            throw new IllegalStateException("Psu with id "+id+" not exist");
        }
        LOGGER.info("Request for delete psu success, id : {} ", id);
        psuRepository.deleteById(id);
    }
}
