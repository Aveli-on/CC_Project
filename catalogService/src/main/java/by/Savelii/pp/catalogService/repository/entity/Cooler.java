package by.Savelii.pp.catalogService.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "cooler", uniqueConstraints = @UniqueConstraint(columnNames = {"brand", "model"}))
public class  Cooler{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String brand;
private String model;
private String type;
private String supportedSockets;
private int tdp;
private int height;
private int radiatorSize;
private BigDecimal price;
private String currency;
private boolean stockAvailable;
@Column(updatable = false)
@CreationTimestamp
private OffsetDateTime createdAt;
@UpdateTimestamp
private OffsetDateTime updatedAt;

    public Cooler() {
    }

    public Cooler(Long id, String brand, String model, String type, String supportedSockets, int tdp, int height, int radiatorSize, BigDecimal price, String currency, boolean stockAvailable, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.supportedSockets = supportedSockets;
        this.tdp = tdp;
        this.height = height;
        this.radiatorSize = radiatorSize;
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

    public String getSupportedSockets() {
        return supportedSockets;
    }

    public void setSupportedSockets(String supportedSockets) {
        this.supportedSockets = supportedSockets;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRadiatorSize() {
        return radiatorSize;
    }

    public void setRadiatorSize(int radiatorSize) {
        this.radiatorSize = radiatorSize;
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