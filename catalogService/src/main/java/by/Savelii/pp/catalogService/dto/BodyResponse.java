package by.Savelii.pp.catalogService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class BodyResponse {
    private Long id;
    private String brand;
    private String model;
    private String formFactor;
    private int maxGpuLength;
    private int maxCpuCoolerHeight;
    private int maxPsuLength;
    private int driveBays35;
    private int driveBays25;
    private int expansionSlots;
    private String fanMounts;
    private BigDecimal price;
    private String currency;
    private boolean stockAvailable;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime updatedAt;

    public BodyResponse() {
    }

    public BodyResponse(Long id, String brand, String model, String formFactor, int maxGpuLength, int maxCpuCoolerHeight, int maxPsuLength, int driveBays35, int driveBays25, int expansionSlots, String fanMounts, BigDecimal price, String currency, boolean stockAvailable, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.formFactor = formFactor;
        this.maxGpuLength = maxGpuLength;
        this.maxCpuCoolerHeight = maxCpuCoolerHeight;
        this.maxPsuLength = maxPsuLength;
        this.driveBays35 = driveBays35;
        this.driveBays25 = driveBays25;
        this.expansionSlots = expansionSlots;
        this.fanMounts = fanMounts;
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

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public int getMaxGpuLength() {
        return maxGpuLength;
    }

    public void setMaxGpuLength(int maxGpuLength) {
        this.maxGpuLength = maxGpuLength;
    }

    public int getMaxCpuCoolerHeight() {
        return maxCpuCoolerHeight;
    }

    public void setMaxCpuCoolerHeight(int maxCpuCoolerHeight) {
        this.maxCpuCoolerHeight = maxCpuCoolerHeight;
    }

    public int getMaxPsuLength() {
        return maxPsuLength;
    }

    public void setMaxPsuLength(int maxPsuLength) {
        this.maxPsuLength = maxPsuLength;
    }

    public int getDriveBays35() {
        return driveBays35;
    }

    public void setDriveBays35(int driveBays35) {
        this.driveBays35 = driveBays35;
    }

    public int getDriveBays25() {
        return driveBays25;
    }

    public void setDriveBays25(int driveBays25) {
        this.driveBays25 = driveBays25;
    }

    public int getExpansionSlots() {
        return expansionSlots;
    }

    public void setExpansionSlots(int expansionSlots) {
        this.expansionSlots = expansionSlots;
    }

    public String getFanMounts() {
        return fanMounts;
    }

    public void setFanMounts(String fanMounts) {
        this.fanMounts = fanMounts;
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

