package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.CoolerRequest;
import by.Savelii.pp.catalogService.dto.CoolerResponse;
import by.Savelii.pp.catalogService.repository.CoolerRepository;
import by.Savelii.pp.catalogService.repository.entity.Cooler;
import by.Savelii.pp.catalogService.service.mappers.CoolerMapper;
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
public class CoolerService {
    private final CoolerRepository coolerRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(CoolerService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public CoolerService(CoolerRepository coolerRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.coolerRepository = coolerRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public CoolerResponse create(CoolerRequest coolerRequest) {
        Optional<Cooler> cooler= coolerRepository.findByBrandAndModel(coolerRequest.getBrand(),coolerRequest.getModel());
        if(cooler.isPresent()){
            LOGGER.info("Cooler {} {} exist",coolerRequest.getBrand(),coolerRequest.getModel());
        }else {
            Cooler newCooler = CoolerMapper.toEntity(coolerRequest);
            Cooler save = coolerRepository.save(newCooler);
            cooler=Optional.of(save);
            LOGGER.info("Cooler created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.COOLER, CoolerMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (MC): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (MC): {}", result.getRecordMetadata());
                }
            });
        }

        return CoolerMapper.toResponse(cooler.get());
    }
    @Transactional
    public CoolerResponse updateById(Long id,CoolerRequest coolerRequest) {
        Optional<Cooler> optionalCooler = coolerRepository.findById(id);
        if(optionalCooler.isEmpty()){
            LOGGER.error("Request for update cooler was failed, id : {} ", id);
            throw new IllegalStateException("Cooler with id "+id+" not exist");
        }
        CoolerMapper.toUpdateEntity(optionalCooler.get(),coolerRequest);
        coolerRepository.save(optionalCooler.get());
        LOGGER.info("Request for update cooler success, id : {} ", id);
        return CoolerMapper.toResponse(optionalCooler.get());
    }
    public CoolerResponse getById(Long id) {
        Optional<Cooler> optionalCooler = coolerRepository.findById(id);
        if(optionalCooler.isEmpty()){
            LOGGER.error("Request for get cooler was failed, id : {} ", id);
            throw new IllegalStateException("Cooler with id "+id+" not exist");
        }
        LOGGER.info("Request for get cooler success, id : {} ", id);
        return CoolerMapper.toResponse(optionalCooler.get());
    }

    public List<CoolerResponse> getAll(){
        return coolerRepository.findAll().stream().map(CoolerMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Cooler> optionalCooler = coolerRepository.findById(id);
        if(optionalCooler.isEmpty()){
            LOGGER.error("Request for delete cooler was failed, id : {} ", id);
            throw new IllegalStateException("Cooler with id "+id+" not exist");
        }
        LOGGER.info("Request for delete cooler success, id : {} ", id);
        coolerRepository.deleteById(id);
    }
}
