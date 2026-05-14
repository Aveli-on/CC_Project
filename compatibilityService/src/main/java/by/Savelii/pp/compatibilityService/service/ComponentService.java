package by.Savelii.pp.compatibilityService.service;

import by.Savelii.pp.compatibilityService.repository.ComponentRepository;
import by.Savelii.pp.compatibilityService.repository.entity.Component;
import by.Savelii.pp.compatibilityService.service.mapper.ComponentMapper;
import by.Savelii.pp.core.ProductCreatedEvent;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComponentService {
    private  ComponentRepository componentRepository;
    private Logger LOGGER= LoggerFactory.getLogger(ComponentService.class);
    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }
    @Transactional
    public void handlerProductCreatedEvent(ProductCreatedEvent event){
        Optional<Component> component = componentRepository.findByProductIdAndComponentType(event.getId(), event.getComponentType());
        if (component.isPresent()){
            ComponentMapper.updateEntity(component.get(),event);
            LOGGER.info("Succesfully updated component");
        }
        else {
            component= Optional.of(ComponentMapper.toEntity(event));
            LOGGER.info("Succesfully created component");
        }
        componentRepository.save(component.get());
        LOGGER.info("Succesfully saved component {}",event.getBrand()+" "+event.getModel());
    }

}
