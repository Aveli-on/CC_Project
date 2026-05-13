package by.Savelii.pp.catalogService.service;
import by.Savelii.pp.catalogService.dto.MotherboardRequest;
import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.repository.MotherboardRepository;
import by.Savelii.pp.catalogService.repository.entity.Motherboard;
import by.Savelii.pp.catalogService.service.mappers.MotherboardMapper;
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
public class MotherboardService {
    private final MotherboardRepository motherboardRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(MotherboardService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public MotherboardService(MotherboardRepository motherboardRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.motherboardRepository = motherboardRepository;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Transactional
    public MotherboardResponse create(MotherboardRequest motherboardRequest) {
        Optional<Motherboard> motherboard=motherboardRepository.findByBrandAndModel(motherboardRequest.getBrand(),motherboardRequest.getModel());
        if(motherboard.isPresent()){
            LOGGER.info("Motherboard {} {} exist",motherboardRequest.getBrand(),motherboardRequest.getModel());
        }else {
            Motherboard newMotherboard = MotherboardMapper.toEntity(motherboardRequest);
            Motherboard save = motherboardRepository.save(newMotherboard);
            motherboard=Optional.of(save);
            LOGGER.info("Motherboard created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.MOTHERBOARD, MotherboardMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (MC): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (MC): {}", result.getRecordMetadata());
                }
            });
        }

        return MotherboardMapper.toResponse(motherboard.get());
    }
    @Transactional
    public MotherboardResponse updateById(Long id,MotherboardRequest motherboardRequest) {
        Optional<Motherboard> optionalMotherboard = motherboardRepository.findById(id);
        if(optionalMotherboard.isEmpty()){
            LOGGER.error("Request for update motherboard was failed, id : {} ", id);
            throw new IllegalStateException("Motherboard with id "+id+" not exist");
        }
        MotherboardMapper.toUpdateEntity(optionalMotherboard.get(),motherboardRequest);
        motherboardRepository.save(optionalMotherboard.get());
        LOGGER.info("Request for update motherboard success, id : {} ", id);
        return MotherboardMapper.toResponse(optionalMotherboard.get());
    }
    public MotherboardResponse getById(Long id) {
        Optional<Motherboard> optionalMotherboard = motherboardRepository.findById(id);
        if(optionalMotherboard.isEmpty()){
            LOGGER.error("Request for get motherboard was failed, id : {} ", id);
            throw new IllegalStateException("Motherboard with id "+id+" not exist");
        }
        LOGGER.info("Request for get motherboard success, id : {} ", id);
        return MotherboardMapper.toResponse(optionalMotherboard.get());
    }

    public List<MotherboardResponse> getAll(){
        return motherboardRepository.findAll().stream().map(MotherboardMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Motherboard> optionalMotherboard = motherboardRepository.findById(id);
        if(optionalMotherboard.isEmpty()){
            LOGGER.error("Request for delete motherboard was failed, id : {} ", id);
            throw new IllegalStateException("Motherboard with id "+id+" not exist");
        }
        LOGGER.info("Request for delete motherboard success, id : {} ", id);
        motherboardRepository.deleteById(id);
    }
}
