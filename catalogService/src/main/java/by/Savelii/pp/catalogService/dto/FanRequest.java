package by.Savelii.pp.catalogService.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class FanRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Positive
    private int size;
    @NotBlank
    private String rpm;
    @Positive
    private double airflow;
    @Positive
    private double noise;
    @NotBlank
    private String connector;
    @Positive
    private BigDecimal price;
    @Size(min=3,max = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public FanRequest() {
    }

    public FanRequest(String brand, String model, int size, String rpm, double airflow, double noise, String connector, BigDecimal price, String currency, boolean stockAvailable) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.rpm = rpm;
        this.airflow = airflow;
        this.noise = noise;
        this.connector = connector;
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
    public int getSize() {
        return size;
    }

    public void setSize(@Positive int size) {
        this.size = size;
    }

    public @NotBlank String getRpm() {
        return rpm;
    }

    public void setRpm(@NotBlank String rpm) {
        this.rpm = rpm;
    }

    @Positive
    public double getAirflow() {
        return airflow;
    }

    public void setAirflow(@Positive double airflow) {
        this.airflow = airflow;
    }

    @Positive
    public double getNoise() {
        return noise;
    }

    public void setNoise(@Positive double noise) {
        this.noise = noise;
    }

    public @NotBlank String getConnector() {
        return connector;
    }

    public void setConnector(@NotBlank String connector) {
        this.connector = connector;
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
