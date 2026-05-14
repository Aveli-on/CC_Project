package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.StorageRequest;
import by.Savelii.pp.catalogService.dto.StorageResponse;
import by.Savelii.pp.catalogService.repository.StorageRepository;
import by.Savelii.pp.catalogService.repository.entity.Storage;
import by.Savelii.pp.catalogService.service.mappers.StorageMapper;
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
public class StorageService {
    private final StorageRepository storageRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(StorageService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public StorageService(StorageRepository storageRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.storageRepository = storageRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public StorageResponse create(StorageRequest storageRequest) {
        Optional<Storage> storage= storageRepository.findByBrandAndModel(storageRequest.getBrand(),storageRequest.getModel());
        if(storage.isPresent()){
            LOGGER.info("Storage {} {} exist",storageRequest.getBrand(),storageRequest.getModel());
        }else {
            Storage newStorage = StorageMapper.toEntity(storageRequest);
            Storage save = storageRepository.save(newStorage);
            storage=Optional.of(save);
            LOGGER.info("Storage created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(),
                    ComponentType.STORAGE, StorageMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (St): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (St): {}", result.getRecordMetadata());
                }
            });
        }

        return StorageMapper.toResponse(storage.get());
    }
    @Transactional
    public StorageResponse updateById(Long id,StorageRequest storageRequest) {
        Optional<Storage> optionalStorage = storageRepository.findById(id);
        if(optionalStorage.isEmpty()){
            LOGGER.error("Request for update storage was failed, id : {} ", id);
            throw new IllegalStateException("Storage with id "+id+" not exist");
        }
        StorageMapper.toUpdateEntity(optionalStorage.get(),storageRequest);
        storageRepository.save(optionalStorage.get());
        LOGGER.info("Request for update storage success, id : {} ", id);
        return StorageMapper.toResponse(optionalStorage.get());
    }
    public StorageResponse getById(Long id) {
        Optional<Storage> optionalStorage = storageRepository.findById(id);
        if(optionalStorage.isEmpty()){
            LOGGER.error("Request for get storage was failed, id : {} ", id);
            throw new IllegalStateException("Storage with id "+id+" not exist");
        }
        LOGGER.info("Request for get storage success, id : {} ", id);
        return StorageMapper.toResponse(optionalStorage.get());
    }

    public List<StorageResponse> getAll(){
        return storageRepository.findAll().stream().map(StorageMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Storage> optionalStorage = storageRepository.findById(id);
        if(optionalStorage.isEmpty()){
            LOGGER.error("Request for delete storage was failed, id : {} ", id);
            throw new IllegalStateException("Storage with id "+id+" not exist");
        }
        LOGGER.info("Request for delete storage success, id : {} ", id);
        storageRepository.deleteById(id);
    }
}
