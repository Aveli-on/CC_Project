package by.Savelii.pp.catalogService.repository;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name="cpuSchema")
public class CpuDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String brand;
    private String model;
    private String socket;
    private int cores;
    private int threads;
    @Column(name = "base_clock")
    private double baseClock;
    @Column(name = "boost_clock")
    private double boostClock;
    private int tdp;
    @Column(name = "integrated_graphics")
    private String integratedGraphics;
    @Column(name = "max_memory_speed")
    private int maxMemorySpeed;
    @Column(name = "memory_type")
    private String memoryType;
    @Column(name = "pcie_version")
    private String pcieVersion;
    private String packaging;
    private double price;
    private String currency;
    @Column(name = "stock_availiable")
    private boolean stockAvailiable;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public CpuDto(BigInteger id, String brand, String model, String socket, int cores,
                  int threads, double baseClock, double boostClock, int tdp, String integratedGraphics,
                  int maxMemorySpeed, String memoryType, String pcieVersion, String packaging, double price,
                  String currency, boolean stockAvailiable, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.socket = socket;
        this.cores = cores;
        this.threads = threads;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
        this.tdp = tdp;
        this.integratedGraphics = integratedGraphics;
        this.maxMemorySpeed = maxMemorySpeed;
        this.memoryType = memoryType;
        this.pcieVersion = pcieVersion;
        this.packaging = packaging;
        this.price = price;
        this.currency = currency;
        this.stockAvailiable = stockAvailiable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(double baseClock) {
        this.baseClock = baseClock;
    }

    public double getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(double boostClock) {
        this.boostClock = boostClock;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    public String getIntegratedGraphics() {
        return integratedGraphics;
    }

    public void setIntegratedGraphics(String integratedGraphics) {
        this.integratedGraphics = integratedGraphics;
    }

    public int getMaxMemorySpeed() {
        return maxMemorySpeed;
    }

    public void setMaxMemorySpeed(int maxMemorySpeed) {
        this.maxMemorySpeed = maxMemorySpeed;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getPcieVersion() {
        return pcieVersion;
    }

    public void setPcieVersion(String pcieVersion) {
        this.pcieVersion = pcieVersion;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isStockAvailiable() {
        return stockAvailiable;
    }

    public void setStockAvailiable(boolean stockAvailiable) {
        this.stockAvailiable = stockAvailiable;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
