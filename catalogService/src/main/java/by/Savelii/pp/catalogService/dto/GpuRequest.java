package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class GpuRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Positive
    private int memorySize;
    @Pattern(regexp = "DDR\\d*\\w*")
    private String memoryType;
    @Positive
    private double coreClock;
    @Positive
    private double boostClock;
    @Positive
    private int tdp;
    @Positive
    private int length;
    @Positive
    private int width;
    @Positive
    private int height;
    @Pattern(regexp = "^\\d\\.\\d$")
    private String pcieVersion;
    @NotBlank
    private String powerConnectors;
    @NotNull
    private int hdmi;
    @NotNull
    private int displayPort;
    @NotNull
    private int dvi;
    @Positive
    private BigDecimal price;
    @Size(max = 3,min = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public GpuRequest() {
    }

    public GpuRequest(String brand, String model, int memorySize, String memoryType, double coreClock, double boostClock, int tdp, int length, int width, int height, String pcieVersion, String powerConnectors, int hdmi, int displayPort, int dvi, BigDecimal price, String currency, boolean stockAvailable) {
        this.brand = brand;
        this.model = model;
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.tdp = tdp;
        this.length = length;
        this.width = width;
        this.height = height;
        this.pcieVersion = pcieVersion;
        this.powerConnectors = powerConnectors;
        this.hdmi = hdmi;
        this.displayPort = displayPort;
        this.dvi = dvi;
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
    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(@Positive int memorySize) {
        this.memorySize = memorySize;
    }

    public @Pattern(regexp = "DDR\\d*\\w*") String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(@Pattern(regexp = "DDR\\d*\\w*") String memoryType) {
        this.memoryType = memoryType;
    }

    @Positive
    public double getCoreClock() {
        return coreClock;
    }

    public void setCoreClock(@Positive double coreClock) {
        this.coreClock = coreClock;
    }

    @Positive
    public double getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(@Positive double boostClock) {
        this.boostClock = boostClock;
    }

    @Positive
    public int getTdp() {
        return tdp;
    }

    public void setTdp(@Positive int tdp) {
        this.tdp = tdp;
    }

    @Positive
    public int getLength() {
        return length;
    }

    public void setLength(@Positive int length) {
        this.length = length;
    }

    @Positive
    public int getWidth() {
        return width;
    }

    public void setWidth(@Positive int width) {
        this.width = width;
    }

    @Positive
    public int getHeight() {
        return height;
    }

    public void setHeight(@Positive int height) {
        this.height = height;
    }

    public @Pattern(regexp = "^\\d\\.\\d$") String getPcieVersion() {
        return pcieVersion;
    }

    public void setPcieVersion(@Pattern(regexp = "^\\d\\.\\d$") String pcieVersion) {
        this.pcieVersion = pcieVersion;
    }

    public @NotBlank String getPowerConnectors() {
        return powerConnectors;
    }

    public void setPowerConnectors(@NotBlank String powerConnectors) {
        this.powerConnectors = powerConnectors;
    }

    @NotNull
    public int getHdmi() {
        return hdmi;
    }

    public void setHdmi(@NotNull int hdmi) {
        this.hdmi = hdmi;
    }

    @NotNull
    public int getDisplayPort() {
        return displayPort;
    }

    public void setDisplayPort(@NotNull int displayPort) {
        this.displayPort = displayPort;
    }

    @NotNull
    public int getDvi() {
        return dvi;
    }

    public void setDvi(@NotNull int dvi) {
        this.dvi = dvi;
    }

    public @Positive BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Positive BigDecimal price) {
        this.price = price;
    }

    public @Size(max = 3, min = 3) String getCurrency() {
        return currency;
    }

    public void setCurrency(@Size(max = 3, min = 3) String currency) {
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
