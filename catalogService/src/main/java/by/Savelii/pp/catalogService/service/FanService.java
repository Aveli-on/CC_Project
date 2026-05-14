package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.FanRequest;
import by.Savelii.pp.catalogService.dto.FanResponse;
import by.Savelii.pp.catalogService.repository.FanRepository;
import by.Savelii.pp.catalogService.repository.entity.Fan;
import by.Savelii.pp.catalogService.service.mappers.FanMapper;
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
public class FanService {
    private final FanRepository fanRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(FanService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public FanService(FanRepository fanRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.fanRepository = fanRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public FanResponse create(FanRequest fanRequest) {
        Optional<Fan> fan= fanRepository.findByBrandAndModel(fanRequest.getBrand(),fanRequest.getModel());
        if(fan.isPresent()){
            LOGGER.info("Fan {} {} exist",fanRequest.getBrand(),fanRequest.getModel());
        }else {
            Fan newFan = FanMapper.toEntity(fanRequest);
            Fan save = fanRepository.save(newFan);
            fan=Optional.of(save);
            LOGGER.info("Fan created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.FAN, FanMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (F): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (F): {}", result.getRecordMetadata());
                }
            });
        }

        return FanMapper.toResponse(fan.get());
    }
    @Transactional
    public FanResponse updateById(Long id,FanRequest fanRequest) {
        Optional<Fan> optionalFan = fanRepository.findById(id);
        if(optionalFan.isEmpty()){
            LOGGER.error("Request for update fan was failed, id : {} ", id);
            throw new IllegalStateException("Fan with id "+id+" not exist");
        }
        FanMapper.toUpdateEntity(optionalFan.get(),fanRequest);
        fanRepository.save(optionalFan.get());
        LOGGER.info("Request for update fan success, id : {} ", id);
        return FanMapper.toResponse(optionalFan.get());
    }
    public FanResponse getById(Long id) {
        Optional<Fan> optionalFan = fanRepository.findById(id);
        if(optionalFan.isEmpty()){
            LOGGER.error("Request for get fan was failed, id : {} ", id);
            throw new IllegalStateException("Fan with id "+id+" not exist");
        }
        LOGGER.info("Request for get fan success, id : {} ", id);
        return FanMapper.toResponse(optionalFan.get());
    }

    public List<FanResponse> getAll(){
        return fanRepository.findAll().stream().map(FanMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Fan> optionalFan = fanRepository.findById(id);
        if(optionalFan.isEmpty()){
            LOGGER.error("Request for delete fan was failed, id : {} ", id);
            throw new IllegalStateException("Fan with id "+id+" not exist");
        }
        LOGGER.info("Request for delete fan success, id : {} ", id);
        fanRepository.deleteById(id);
    }
}
