package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.GpuRequest;
import by.Savelii.pp.catalogService.dto.GpuResponse;
import by.Savelii.pp.catalogService.repository.GpuRepository;
import by.Savelii.pp.catalogService.repository.entity.Gpu;
import by.Savelii.pp.catalogService.service.mappers.GpuMapper;
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
public class GpuService {
    private final GpuRepository gpuRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(GpuService.class);
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public GpuService(GpuRepository gpuRepository, KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.gpuRepository = gpuRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public GpuResponse create(GpuRequest gpuRequest) {
        Optional<Gpu> gpu= gpuRepository.findByBrandAndModel(gpuRequest.getBrand(),gpuRequest.getModel());
        if(gpu.isPresent()){
            LOGGER.info("Gpu {} {} exist",gpuRequest.getBrand(),gpuRequest.getModel());
        }else {
            Gpu newGpu = GpuMapper.toEntity(gpuRequest);
            Gpu save = gpuRepository.save(newGpu);
            gpu=Optional.of(save);
            LOGGER.info("Gpu created, id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic",
                    save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.GPU, GpuMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("Failed to send message (GP): {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully (GP): {}", result.getRecordMetadata());
                }
            });
        }

        return GpuMapper.toResponse(gpu.get());
    }
    @Transactional
    public GpuResponse updateById(Long id,GpuRequest gpuRequest) {
        Optional<Gpu> optionalGpu = gpuRepository.findById(id);
        if(optionalGpu.isEmpty()){
            LOGGER.error("Request for update gpu was failed, id : {} ", id);
            throw new IllegalStateException("Gpu with id "+id+" not exist");
        }
        GpuMapper.toUpdateEntity(optionalGpu.get(),gpuRequest);
        gpuRepository.save(optionalGpu.get());
        LOGGER.info("Request for update gpu success, id : {} ", id);
        return GpuMapper.toResponse(optionalGpu.get());
    }
    public GpuResponse getById(Long id) {
        Optional<Gpu> optionalGpu = gpuRepository.findById(id);
        if(optionalGpu.isEmpty()){
            LOGGER.error("Request for get gpu was failed, id : {} ", id);
            throw new IllegalStateException("Gpu with id "+id+" not exist");
        }
        LOGGER.info("Request for get gpu success, id : {} ", id);
        return GpuMapper.toResponse(optionalGpu.get());
    }

    public List<GpuResponse> getAll(){
        return gpuRepository.findAll().stream().map(GpuMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Gpu> optionalGpu = gpuRepository.findById(id);
        if(optionalGpu.isEmpty()){
            LOGGER.error("Request for delete gpu was failed, id : {} ", id);
            throw new IllegalStateException("Gpu with id "+id+" not exist");
        }
        LOGGER.info("Request for delete gpu success, id : {} ", id);
        gpuRepository.deleteById(id);
    }
}
