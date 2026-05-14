package by.Savelii.pp.compatibilityService.service.mapper;

import by.Savelii.pp.compatibilityService.repository.entity.Component;
import by.Savelii.pp.core.ProductCreatedEvent;

public class ComponentMapper {
    public static Component toEntity(ProductCreatedEvent productCreatedEvent){
        Component component=new Component();
        component.setProductId(productCreatedEvent.getId());
        component.setModel(productCreatedEvent.getModel());
        component.setBrand(productCreatedEvent.getBrand());
        component.setComponentType(productCreatedEvent.getComponentType());
        component.setSpecifications(productCreatedEvent.getSpecifications());


        return component;
    }
    public static void updateEntity(Component component, ProductCreatedEvent productCreatedEvent){
        component.setProductId(productCreatedEvent.getId());
        component.setModel(productCreatedEvent.getModel());
        component.setBrand(productCreatedEvent.getBrand());
        component.setComponentType(productCreatedEvent.getComponentType());
        component.setSpecifications(productCreatedEvent.getSpecifications());
    }

}
