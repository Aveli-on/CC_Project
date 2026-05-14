package by.Savelii.pp.core;

import java.util.Map;

public class ProductCreatedEvent {
    private Long id;
    private String brand;
    private String model;
    private ComponentType componentType;
    private Map<String,String> specifications;

    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(Long id, String brand, String model, ComponentType componentType, Map<String, String> specifications) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.componentType = componentType;
        this.specifications = specifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public Map<String, String> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }
}
