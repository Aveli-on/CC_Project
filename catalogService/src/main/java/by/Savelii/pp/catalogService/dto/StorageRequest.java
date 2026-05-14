package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class StorageRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String type;
    @Positive
    private int capacity;
    @Pattern(regexp = "M.2 NVMe|M.2 SATA|2.5 SATA|3.5 HDD|2.5 HDD|2.5 SHDD")
    private String storageInterface;
    @NotBlank
    private String formFactor;
    @Positive
    private int maxReadSpeed;
    @Positive
    private int maxWriteSpeed;
    @Positive
    private int tdp;
    @Positive
    private BigDecimal price;
    @Size(min=3,max=3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public StorageRequest() {
    }

    public StorageRequest(String brand, String model, String type, int capacity, String storageInterface, String formFactor, int maxReadSpeed, int maxWriteSpeed, int tdp, BigDecimal price, String currency, boolean stockAvailable) {
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
    }

    public @NotBlank String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank String brand) {
        this.brand = brand;
    }

    public @NotBlank String getModel() {
        return model;
    }

    public void setModel(@NotBlank String model) {
        this.model = model;
    }

    public @NotBlank String getType() {
        return type;
    }

    public void setType(@NotBlank String type) {
        this.type = type;
    }

    @Positive
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@Positive int capacity) {
        this.capacity = capacity;
    }

    public @Pattern(regexp = "M.2 NVMe|M.2 SATA|2.5 SATA|3.5 HDD|2.5 HDD|2.5 SHDD") String getStorageInterface() {
        return storageInterface;
    }

    public void setStorageInterface(@Pattern(regexp = "M.2 NVMe|M.2 SATA|2.5 SATA|3.5 HDD|2.5 HDD|2.5 SHDD") String storageInterface) {
        this.storageInterface = storageInterface;
    }

    public @NotBlank String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(@NotBlank String formFactor) {
        this.formFactor = formFactor;
    }

    @Positive
    public int getMaxReadSpeed() {
        return maxReadSpeed;
    }

    public void setMaxReadSpeed(@Positive int maxReadSpeed) {
        this.maxReadSpeed = maxReadSpeed;
    }

    @Positive
    public int getMaxWriteSpeed() {
        return maxWriteSpeed;
    }

    public void setMaxWriteSpeed(@Positive int maxWriteSpeed) {
        this.maxWriteSpeed = maxWriteSpeed;
    }

    @Positive
    public int getTdp() {
        return tdp;
    }

    public void setTdp(@Positive int tdp) {
        this.tdp = tdp;
    }

    public @Positive BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Positive BigDecimal price) {
        this.price = price;
    }

    public @Size(min = 3, max = 3) String getCurrency() {
        return currency;
    }

    public void setCurrency(@Size(min = 3, max = 3) String currency) {
        this.currency = currency;
    }

    @NotNull
    public boolean isStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(@NotNull boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
    }
}
