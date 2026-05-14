package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ExpansionRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String type;
    @NotBlank
    private String expansionInterface;
    @Positive
    private int slotsRequired;
    @Positive
    private BigDecimal price;
    @Size(min = 3,max = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public ExpansionRequest() {
    }

    public ExpansionRequest(String brand, String model, String type, String expansionInterface, int slotsRequired, BigDecimal price, String currency, boolean stockAvailable) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.expansionInterface = expansionInterface;
        this.slotsRequired = slotsRequired;
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

    public @NotBlank String getExpansionInterface() {
        return expansionInterface;
    }

    public void setExpansionInterface(@NotBlank String expansionInterface) {
        this.expansionInterface = expansionInterface;
    }

    @Positive
    public int getSlotsRequired() {
        return slotsRequired;
    }

    public void setSlotsRequired(@Positive int slotsRequired) {
        this.slotsRequired = slotsRequired;
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
