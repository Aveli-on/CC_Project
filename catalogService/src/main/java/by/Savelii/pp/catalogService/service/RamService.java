package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.RamRequest;
import by.Savelii.pp.catalogService.dto.RamResponse;
import by.Savelii.pp.catalogService.repository.RamRepository;
import by.Savelii.pp.catalogService.repository.entity.Ram;
import by.Savelii.pp.catalogService.service.mappers.RamMapper;
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
public class RamService {
    private final RamRepository ramRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(RamService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public RamService(RamRepository ramRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.ramRepository = ramRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public RamResponse create(RamRequest ramRequest) {
        Optional<Ram> ram= ramRepository.findByBrandAndModel(ramRequest.getBrand(),ramRequest.getModel());
        if(ram.isPresent()){
            LOGGER.info("Ram {} {} exist",ramRequest.getBrand(),ramRequest.getModel());
        }else {
            Ram newRam = RamMapper.toEntity(ramRequest);
            Ram save = ramRepository.save(newRam);
            ram=Optional.of(save);
            LOGGER.info("Ram created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(),
                    ComponentType.RAM, RamMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (RM): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (RM): {}", result.getRecordMetadata());
                }
            });
        }

        return RamMapper.toResponse(ram.get());
    }
    @Transactional
    public RamResponse updateById(Long id,RamRequest ramRequest) {
        Optional<Ram> optionalRam = ramRepository.findById(id);
        if(optionalRam.isEmpty()){
            LOGGER.error("Request for update ram was failed, id : {} ", id);
            throw new IllegalStateException("Ram with id "+id+" not exist");
        }
        RamMapper.toUpdateEntity(optionalRam.get(),ramRequest);
        ramRepository.save(optionalRam.get());
        LOGGER.info("Request for update ram success, id : {} ", id);
        return RamMapper.toResponse(optionalRam.get());
    }
    public RamResponse getById(Long id) {
        Optional<Ram> optionalRam = ramRepository.findById(id);
        if(optionalRam.isEmpty()){
            LOGGER.error("Request for get ram was failed, id : {} ", id);
            throw new IllegalStateException("Ram with id "+id+" not exist");
        }
        LOGGER.info("Request for get ram success, id : {} ", id);
        return RamMapper.toResponse(optionalRam.get());
    }

    public List<RamResponse> getAll(){
        return ramRepository.findAll().stream().map(RamMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Ram> optionalRam = ramRepository.findById(id);
        if(optionalRam.isEmpty()){
            LOGGER.error("Request for delete ram was failed, id : {} ", id);
            throw new IllegalStateException("Ram with id "+id+" not exist");
        }
        LOGGER.info("Request for delete ram success, id : {} ", id);
        ramRepository.deleteById(id);
    }
}
