package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class RamRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Pattern(regexp = "DDR\\d")
    private String memoryType;
    @Positive
    private int capacity;
    @Positive
    private int speed;
    @Pattern(regexp = "CL\\d+")
    private String latency;
    @Positive
    private int kit;
    @Positive
    private double voltage;
    @Positive
    private BigDecimal price;
    @Size(min = 3, max = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public RamRequest() {
    }

    public RamRequest(String brand, String model, String memoryType, int capacity, int speed, String latency, int kit, double voltage, BigDecimal price, String currency, boolean stockAvailable) {
        this.brand = brand;
        this.model = model;
        this.memoryType = memoryType;
        this.capacity = capacity;
        this.speed = speed;
        this.latency = latency;
        this.kit = kit;
        this.voltage = voltage;
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

    public @Pattern(regexp = "DDR\\d") String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(@Pattern(regexp = "DDR\\d") String memoryType) {
        this.memoryType = memoryType;
    }

    @Positive
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@Positive int capacity) {
        this.capacity = capacity;
    }

    @Positive
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(@Positive int speed) {
        this.speed = speed;
    }

    public @Pattern(regexp = "CL\\d+") String getLatency() {
        return latency;
    }

    public void setLatency(@Pattern(regexp = "CL\\d+") String latency) {
        this.latency = latency;
    }

    @Positive
    public int getKit() {
        return kit;
    }

    public void setKit(@Positive int kit) {
        this.kit = kit;
    }

    @Positive
    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(@Positive double voltage) {
        this.voltage = voltage;
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
