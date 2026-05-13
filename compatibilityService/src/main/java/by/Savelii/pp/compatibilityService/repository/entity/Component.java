package by.Savelii.pp.compatibilityService.repository.entity;

import by.Savelii.pp.core.ComponentType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
@Entity
@Table(name="component", schema = "compatibility_service",uniqueConstraints = @UniqueConstraint(columnNames = {"product_id","component_type"}))
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    private ComponentType componentType;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String,String> specifications;
    @Column(updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime  updatedAt;

    public Component() {
    }

    public Component(Long id, Long productId, String brand, String model, ComponentType componentType, Map<String, String> specifications, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.productId = productId;
        this.brand = brand;
        this.model = model;
        this.componentType = componentType;
        this.specifications = specifications;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
