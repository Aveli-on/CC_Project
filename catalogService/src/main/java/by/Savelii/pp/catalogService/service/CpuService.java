package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.dto.CpuRequest;
import by.Savelii.pp.catalogService.dto.CpuResponse;
import by.Savelii.pp.catalogService.repository.entity.Cpu;
import by.Savelii.pp.catalogService.repository.CpuRepository;
import by.Savelii.pp.catalogService.service.mappers.CpuMapper;
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
public class CpuService {
    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final CpuRepository cpuRepository;
    public CpuService(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate, CpuRepository cpuRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.cpuRepository=cpuRepository;
    }
    @Transactional
    public CpuResponse create(CpuRequest cpuRequest) {
        Optional<Cpu> cpu=cpuRepository.findByBrandAndModel(cpuRequest.getBrand(),cpuRequest.getModel());
        if(cpu.isPresent()){
            LOGGER.info("Processor {} {} exist",cpuRequest.getBrand(),cpuRequest.getModel());
        }else {
            Cpu newCpu = CpuMapper.toEntity(cpuRequest);
            Cpu save = cpuRepository.save(newCpu);
            cpu=Optional.of(save);
            LOGGER.info("Создан процессор с id: {}", save.getId());
            CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic", save.getId().toString(), new ProductCreatedEvent(save.getId(), save.getBrand(), save.getModel(), ComponentType.CPU, CpuMapper.toSpecificationsMap(save)));
            future.whenComplete((result, exception) -> {
                if (exception != null) {
                    LOGGER.error("failed to send message: {}", exception.getMessage());
                } else {
                    LOGGER.info("Message sent successfully: {}", result.getRecordMetadata());
                }
            });
        }


        return CpuMapper.toResponse(cpu.get());
    }
    @Transactional
    public CpuResponse updateById(Long id,CpuRequest cpuRequest) {
        Optional<Cpu> optionalCpu = cpuRepository.findById(id);
        if(optionalCpu.isEmpty()){
            LOGGER.error("Запрос на обновление процессора с id : {} , ОШИБКА", id);
            throw new IllegalStateException("Пользователя с таким id не существует");
        }
        CpuMapper.toUpdateEntity(optionalCpu.get(),cpuRequest);
        cpuRepository.save(optionalCpu.get());
        return CpuMapper.toResponse(optionalCpu.get());
    }



    public CpuResponse getById(Long id) {
        Optional<Cpu> optionalCpu = cpuRepository.findById(id);
        if(optionalCpu.isEmpty()){
            LOGGER.error("Запрос на поиск процессора с id : {} , ОШИБКА", id);
            throw new IllegalStateException("Пользователя с таким id не существует");
        }
        LOGGER.info("Запрос на поиск процессора с id : {} , успешен", id);
        return CpuMapper.toResponse(optionalCpu.get());
    }

    public List<CpuResponse> getAll(){
        return cpuRepository.findAll().stream().map(CpuMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Cpu> optionalCpu = cpuRepository.findById(id);
        if(optionalCpu.isEmpty()){
            LOGGER.error("Запрос на удаление процессора с id : {} , ОШИБКА", id);
            throw new IllegalStateException("Пользователя с таким id не существует");
        }
        LOGGER.info("Запрос на удаление процессора с id : {} , успешен", id);
        cpuRepository.deleteById(id);
    }
}
