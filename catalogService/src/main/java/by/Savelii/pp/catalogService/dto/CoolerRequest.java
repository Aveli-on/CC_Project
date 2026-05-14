package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CoolerRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Pattern(regexp = "AIR|LIQUID")
    private String type;
    @NotBlank
    private String supportedSockets;
    @Positive
    private int tdp;
    @Positive
    private int height;
    @Positive
    private int radiatorSize;
    @Positive
    private BigDecimal price;
    @Size(min=3,max = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public CoolerRequest() {
    }

    public CoolerRequest(String brand, String model, String type, String supportedSockets, int tdp, int height, int radiatorSize, BigDecimal price, String currency, boolean stockAvailable) {
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

    public @Pattern(regexp = "AIR|LIQUID") String getType() {
        return type;
    }

    public void setType(@Pattern(regexp = "AIR|LIQUID") String type) {
        this.type = type;
    }

    public @NotBlank String getSupportedSockets() {
        return supportedSockets;
    }

    public void setSupportedSockets(@NotBlank String supportedSockets) {
        this.supportedSockets = supportedSockets;
    }

    @Positive
    public int getTdp() {
        return tdp;
    }

    public void setTdp(@Positive int tdp) {
        this.tdp = tdp;
    }

    @Positive
    public int getHeight() {
        return height;
    }

    public void setHeight(@Positive int height) {
        this.height = height;
    }

    public @NotBlank int getRadiatorSize() {
        return radiatorSize;
    }

    public void setRadiatorSize(@NotBlank int radiatorSize) {
        this.radiatorSize = radiatorSize;
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

