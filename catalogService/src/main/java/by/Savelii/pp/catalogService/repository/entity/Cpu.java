package by.Savelii.pp.catalogService.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name="cpu",uniqueConstraints = @UniqueConstraint(columnNames = {"brand","model"}))
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String socket;
    private int cores;
    private int threads;
    private double baseClock;
    private double boostClock;
    private int tdp;
    private String integratedGraphics;
    private int maxMemorySpeed;
    private String memoryType;
    private String pcieVersion;
    private String packaging;
    private BigDecimal price;
    private String currency;
    private boolean stockAvailable;
    @Column(updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime  updatedAt;

    public Cpu() {
    }

    public Cpu(Long id, String brand, String model, String socket, int cores,
               int threads, double baseClock, double boostClock, int tdp, String integratedGraphics,
               int maxMemorySpeed, String memoryType, String pcieVersion, String packaging, BigDecimal price,
               String currency, boolean stockAvailable, OffsetDateTime  createdAt, OffsetDateTime  updatedAt) {
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

    public OffsetDateTime  getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime  createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime  getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime  updatedAt) {
        this.updatedAt = updatedAt;
    }
}
