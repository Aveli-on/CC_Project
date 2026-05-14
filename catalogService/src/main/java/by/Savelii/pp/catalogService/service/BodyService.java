package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.BodyRequest;
import by.Savelii.pp.catalogService.dto.BodyResponse;
import by.Savelii.pp.catalogService.repository.BodyRepository;
import by.Savelii.pp.catalogService.repository.entity.Body;
import by.Savelii.pp.catalogService.service.mappers.BodyMapper;
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
public class BodyService {
    private final BodyRepository bodyRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(BodyRepository.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public BodyService(BodyRepository bodyRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.bodyRepository = bodyRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public BodyResponse create(BodyRequest bodyRequest) {
        Optional<Body> body= bodyRepository.findByBrandAndModel(bodyRequest.getBrand(),bodyRequest.getModel());
        if(body.isPresent()){
            LOGGER.info("Body {} {} exist",bodyRequest.getBrand(),bodyRequest.getModel());
        }else {
            Body newBody = BodyMapper.toEntity(bodyRequest);
            Body save = bodyRepository.save(newBody);
            body=Optional.of(save);
            LOGGER.info("Body created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.BODY, BodyMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (Bd): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (Bd): {}", result.getRecordMetadata());
                }
            });
        }

        return BodyMapper.toResponse(body.get());
    }
    @Transactional
    public BodyResponse updateById(Long id,BodyRequest bodyRequest) {
        Optional<Body> optionaloptionalBody = bodyRepository.findById(id);
        if(optionaloptionalBody.isEmpty()){
            LOGGER.error("Request for update body was failed, id : {} ", id);
            throw new IllegalStateException("Body with id "+id+" not exist");
        }
        BodyMapper.toUpdateEntity(optionaloptionalBody.get(),bodyRequest);
        bodyRepository.save(optionaloptionalBody.get());
        LOGGER.info("Request for update body success, id : {} ", id);
        return BodyMapper.toResponse(optionaloptionalBody.get());
    }
    public BodyResponse getById(Long id) {
        Optional<Body> optionalBody = bodyRepository.findById(id);
        if(optionalBody.isEmpty()){
            LOGGER.error("Request for get body was failed, id : {} ", id);
            throw new IllegalStateException("Body with id "+id+" not exist");
        }
        LOGGER.info("Request for get body success, id : {} ", id);
        return BodyMapper.toResponse(optionalBody.get());
    }

    public List<BodyResponse> getAll(){
        return bodyRepository.findAll().stream().map(BodyMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Body> optionalBody = bodyRepository.findById(id);
        if(optionalBody.isEmpty()){
            LOGGER.error("Request for delete body was failed, id : {} ", id);
            throw new IllegalStateException("Body with id "+id+" not exist");
        }
        LOGGER.info("Request for delete body  success, id : {} ", id);
        bodyRepository.deleteById(id);
    }
}
