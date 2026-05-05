package by.Savelii.pp.catalogService.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CpuRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String socket;
    @Positive
    private int cores;
    @Positive
    private int threads;
    @Positive
    private double baseClock;
    @Positive
    private double boostClock;
    @Positive
    private int tdp;
    @NotBlank
    private String integratedGraphics;
    @Positive
    private int maxMemorySpeed;
    @NotBlank
    private String memoryType;
    @Pattern(regexp = "^\\d\\.\\d$")
    private String pcieVersion;
    @Pattern(regexp = "BOX|OEM|TRAY")
    private String packaging;
    @Positive
    private BigDecimal price;
    @NotBlank
    @Size(min = 3,max = 3)
    private String currency;
    private boolean stockAvailable;

    public boolean isStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public @NotBlank @Size(min = 3, max = 3) String getCurrency() {
        return currency;
    }

    public void setCurrency(@NotBlank @Size(min = 3, max = 3) String currency) {
        this.currency = currency;
    }

    public @Positive BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Positive BigDecimal price) {
        this.price = price;
    }

    public @Pattern(regexp = "BOX|OEM|TRAY") String getPackaging() {
        return packaging;
    }

    public void setPackaging(@Pattern(regexp = "BOX|OEM|TRAY") String packaging) {
        this.packaging = packaging;
    }

    public @Pattern(regexp = "^\\d\\.\\d$") String getPcieVersion() {
        return pcieVersion;
    }

    public void setPcieVersion(@Pattern(regexp = "^\\d\\.\\d$") String pcieVersion) {
        this.pcieVersion = pcieVersion;
    }

    public @NotBlank String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(@NotBlank String memoryType) {
        this.memoryType = memoryType;
    }

    @Positive
    public int getMaxMemorySpeed() {
        return maxMemorySpeed;
    }

    public void setMaxMemorySpeed(@Positive int maxMemorySpeed) {
        this.maxMemorySpeed = maxMemorySpeed;
    }

    public @NotBlank String getIntegratedGraphics() {
        return integratedGraphics;
    }

    public void setIntegratedGraphics(@NotBlank String integratedGraphics) {
        this.integratedGraphics = integratedGraphics;
    }

    @Positive
    public int getTdp() {
        return tdp;
    }

    public void setTdp(@Positive int tdp) {
        this.tdp = tdp;
    }

    @Positive
    public double getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(@Positive double boostClock) {
        this.boostClock = boostClock;
    }

    @Positive
    public double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(@Positive double baseClock) {
        this.baseClock = baseClock;
    }

    @Positive
    public int getThreads() {
        return threads;
    }

    public void setThreads(@Positive int threads) {
        this.threads = threads;
    }

    @Positive
    public int getCores() {
        return cores;
    }

    public void setCores(@Positive int cores) {
        this.cores = cores;
    }

    public @NotBlank String getSocket() {
        return socket;
    }

    public void setSocket(@NotBlank String socket) {
        this.socket = socket;
    }

    public @NotBlank String getModel() {
        return model;
    }

    public void setModel(@NotBlank String model) {
        this.model = model;
    }

    public @NotBlank String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank String brand) {
        this.brand = brand;
    }
}
