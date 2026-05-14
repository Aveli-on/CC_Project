package by.Savelii.pp.catalogService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PsuResponse {
    private Long id;
    private String brand;
    private String model;
    private int wattage;
    private String formFactor;
    private String modular;
    private String efficiencyRating;
    private int pcie6plus2;
    private int pcie8pin;
    private int sata;
    private int molex;
    private int length;
    private BigDecimal price;
    private String currency;
    private boolean stockAvailable;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime updatedAt;
    public PsuResponse() {
    }
    public PsuResponse(Long id, String brand, String model, int wattage, String formFactor, String modular, String efficiencyRating, int pcie6plus2, int pcie8pin, int sata, int molex, int length, BigDecimal price, String currency, boolean stockAvailable, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
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

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular;
    }

    public String getEfficiencyRating() {
        return efficiencyRating;
    }

    public void setEfficiencyRating(String efficiencyRating) {
        this.efficiencyRating = efficiencyRating;
    }

    public int getPcie6plus2() {
        return pcie6plus2;
    }

    public void setPcie6plus2(int pcie6plus2) {
        this.pcie6plus2 = pcie6plus2;
    }

    public int getPcie8pin() {
        return pcie8pin;
    }

    public void setPcie8pin(int pcie8pin) {
        this.pcie8pin = pcie8pin;
    }

    public int getSata() {
        return sata;
    }

    public void setSata(int sata) {
        this.sata = sata;
    }

    public int getMolex() {
        return molex;
    }

    public void setMolex(int molex) {
        this.molex = molex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
