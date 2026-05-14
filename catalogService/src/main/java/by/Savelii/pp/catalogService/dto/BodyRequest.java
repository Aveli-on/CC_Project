package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class BodyRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String formFactor;
    @Positive
    private int maxGpuLength;
    @Positive
    private int maxCpuCoolerHeight;
    @Positive
    private int maxPsuLength;
    @Min(0)
    private int driveBays35;
    @Min(0)
    private int driveBays25;
    @Min(0)
    private int expansionSlots;
    @NotBlank
    private String fanMounts;
    @Positive
    private BigDecimal price;
    @Size(min = 3,max = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public BodyRequest() {
    }

    public BodyRequest(String brand, String model, String formFactor, int maxGpuLength, int maxCpuCoolerHeight, int maxPsuLength, int driveBays35, int driveBays25, int expansionSlots, String fanMounts, BigDecimal price, String currency, boolean stockAvailable) {
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

    public @NotBlank String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(@NotBlank String formFactor) {
        this.formFactor = formFactor;
    }

    @Positive
    public int getMaxGpuLength() {
        return maxGpuLength;
    }

    public void setMaxGpuLength(@Positive int maxGpuLength) {
        this.maxGpuLength = maxGpuLength;
    }

    @Positive
    public int getMaxCpuCoolerHeight() {
        return maxCpuCoolerHeight;
    }

    public void setMaxCpuCoolerHeight(@Positive int maxCpuCoolerHeight) {
        this.maxCpuCoolerHeight = maxCpuCoolerHeight;
    }

    @Positive
    public int getMaxPsuLength() {
        return maxPsuLength;
    }

    public void setMaxPsuLength(@Positive int maxPsuLength) {
        this.maxPsuLength = maxPsuLength;
    }

    @Min(0)
    public int getDriveBays35() {
        return driveBays35;
    }

    public void setDriveBays35(@Min(0) int driveBays35) {
        this.driveBays35 = driveBays35;
    }

    @Min(0)
    public int getDriveBays25() {
        return driveBays25;
    }

    public void setDriveBays25(@Min(0) int driveBays25) {
        this.driveBays25 = driveBays25;
    }

    @Min(0)
    public int getExpansionSlots() {
        return expansionSlots;
    }

    public void setExpansionSlots(@Min(0) int expansionSlots) {
        this.expansionSlots = expansionSlots;
    }

    public @NotBlank String getFanMounts() {
        return fanMounts;
    }

    public void setFanMounts(@NotBlank String fanMounts) {
        this.fanMounts = fanMounts;
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
