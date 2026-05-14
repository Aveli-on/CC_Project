package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class PsuRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Positive
    private int wattage;
    @NotBlank
    private String formFactor;
    @Pattern(regexp = "Full|Semi|None")
    private String modular;
    @NotBlank
    private String efficiencyRating;
    @Min(0)
    private int pcie6plus2;
    @Min(0)
    private int pcie8pin;
    @Min(0)
    private int sata;
    @Min(0)
    private int molex;
    @Positive
    private int length;
    @Positive
    private BigDecimal price;
    @Size(min = 3,max = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public PsuRequest() {
    }

    public PsuRequest(String brand, String model, int wattage, String formFactor, String modular, String efficiencyRating, int pcie6plus2, int pcie8pin, int sata, int molex, int length, BigDecimal price, String currency, boolean stockAvailable) {
        this.brand = brand;
        this.model = model;
        this.wattage = wattage;
        this.formFactor = formFactor;
        this.modular = modular;
        this.efficiencyRating = efficiencyRating;
        this.pcie6plus2 = pcie6plus2;
        this.pcie8pin = pcie8pin;
        this.sata = sata;
        this.molex = molex;
        this.length = length;
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

    @Positive
    public int getWattage() {
        return wattage;
    }

    public void setWattage(@Positive int wattage) {
        this.wattage = wattage;
    }

    public @NotBlank String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(@NotBlank String formFactor) {
        this.formFactor = formFactor;
    }

    public @Pattern(regexp = "Full|Semi|None") String getModular() {
        return modular;
    }

    public void setModular(@Pattern(regexp = "Full|Semi|None") String modular) {
        this.modular = modular;
    }

    public @NotBlank String getEfficiencyRating() {
        return efficiencyRating;
    }

    public void setEfficiencyRating(@NotBlank String efficiencyRating) {
        this.efficiencyRating = efficiencyRating;
    }

    @Min(0)
    public int getPcie6plus2() {
        return pcie6plus2;
    }

    public void setPcie6plus2(@Min(0) int pcie6plus2) {
        this.pcie6plus2 = pcie6plus2;
    }

    @Min(0)
    public int getPcie8pin() {
        return pcie8pin;
    }

    public void setPcie8pin(@Min(0) int pcie8pin) {
        this.pcie8pin = pcie8pin;
    }

    @Min(0)
    public int getSata() {
        return sata;
    }

    public void setSata(@Min(0) int sata) {
        this.sata = sata;
    }

    @Min(0)
    public int getMolex() {
        return molex;
    }

    public void setMolex(@Min(0) int molex) {
        this.molex = molex;
    }

    @Positive
    public int getLength() {
        return length;
    }

    public void setLength(@Positive int length) {
        this.length = length;
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
