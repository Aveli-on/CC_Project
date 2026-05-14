package by.Savelii.pp.catalogService.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "storage", uniqueConstraints = @UniqueConstraint(columnNames = {"brand", "model"}))
public class Storage {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String brand;
private String model;
private String type;
private int capacity;
private String storageInterface;
private String formFactor;
private int maxReadSpeed;
private int maxWriteSpeed;
private int tdp;
private BigDecimal price;
private String currency;
private boolean stockAvailable;
@Column(updatable = false)
@CreationTimestamp
private OffsetDateTime createdAt;
@UpdateTimestamp
private OffsetDateTime updatedAt;

    public Storage() {
    }

    public Storage(Long id, String brand, String model, String type, int capacity, String storageInterface, String formFactor, int maxReadSpeed, int maxWriteSpeed, int tdp, BigDecimal price, String currency, boolean stockAvailable, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.capacity = capacity;
        this.storageInterface = storageInterface;
        this.formFactor = formFactor;
        this.maxReadSpeed = maxReadSpeed;
        this.maxWriteSpeed = maxWriteSpeed;
        this.tdp = tdp;
        this.price = price;
        this.currency = currency;
        this.stockAvailable = stockAvailable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStorageInterface() {
        return storageInterface;
    }

    public void setStorageInterface(String storageInterface) {
        this.storageInterface = storageInterface;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public int getMaxReadSpeed() {
        return maxReadSpeed;
    }

    public void setMaxReadSpeed(int maxReadSpeed) {
        this.maxReadSpeed = maxReadSpeed;
    }

    public int getMaxWriteSpeed() {
        return maxWriteSpeed;
    }

    public void setMaxWriteSpeed(int maxWriteSpeed) {
        this.maxWriteSpeed = maxWriteSpeed;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
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