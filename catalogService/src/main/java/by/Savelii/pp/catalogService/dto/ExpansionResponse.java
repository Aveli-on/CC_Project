package by.Savelii.pp.catalogService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ExpansionResponse {
    private Long id;
    private String brand;
    private String model;
    private String type;
    private String expansionInterface;
    private int slotsRequired;
    private BigDecimal price;
    private String currency;
    private boolean stockAvailable;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime updatedAt;

    public ExpansionResponse() {
    }

    public ExpansionResponse(Long id, String brand, String model, String type, String expansionInterface, int slotsRequired, BigDecimal price, String currency, boolean stockAvailable, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.expansionInterface = expansionInterface;
        this.slotsRequired = slotsRequired;
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

    public String getExpansionInterface() {
        return expansionInterface;
    }

    public void setExpansionInterface(String expansionInterface) {
        this.expansionInterface = expansionInterface;
    }

    public int getSlotsRequired() {
        return slotsRequired;
    }

    public void setSlotsRequired(int slotsRequired) {
        this.slotsRequired = slotsRequired;
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
