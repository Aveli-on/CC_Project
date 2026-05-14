package by.Savelii.pp.catalogService.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "motherboard",uniqueConstraints = @UniqueConstraint(columnNames = {"brand","model"}))
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String socket;
    private String chipset;
    private String formFactor;
    private String memoryType;
    private int maxMemorySpeed;
    private int maxMemoryCapacity;
    private int memorySlots;
    private boolean ramDualChannel;
    private String pcieVersion;
    private int m2Slots;
    private String m2PcieVersion ;
    private String videoPorts  ;
    private int sataPorts   ;
    private String lan;
    private String wifi;
    private String audioChipset;
    private boolean rgbHeader   ;
    private BigDecimal price;
    private String currency;
    private boolean stockAvailable;
    @Column(updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime  updatedAt;

    public Motherboard() {
    }

    public Motherboard(Long id, String brand, String model, String socket, String chipset, String formFactor, String memoryType, int maxMemorySpeed, int maxMemoryCapacity, int memorySlots, boolean ramDualChannel, String pcieVersion, int m2Slots, String m2PcieVersion, String videoPorts, int sataPorts, String lan, String wifi, String audioChipset, boolean rgbHeader, BigDecimal price, String currency, boolean stockAvailable, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.socket = socket;
        this.chipset = chipset;
        this.formFactor = formFactor;
        this.memoryType = memoryType;
        this.maxMemorySpeed = maxMemorySpeed;
        this.maxMemoryCapacity = maxMemoryCapacity;
        this.memorySlots = memorySlots;
        this.ramDualChannel = ramDualChannel;
        this.pcieVersion = pcieVersion;
        this.m2Slots = m2Slots;
        this.m2PcieVersion = m2PcieVersion;
        this.videoPorts = videoPorts;
        this.sataPorts = sataPorts;
        this.lan = lan;
        this.wifi = wifi;
        this.audioChipset = audioChipset;
        this.rgbHeader = rgbHeader;
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

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getMaxMemorySpeed() {
        return maxMemorySpeed;
    }

    public void setMaxMemorySpeed(int maxMemorySpeed) {
        this.maxMemorySpeed = maxMemorySpeed;
    }

    public int getMaxMemoryCapacity() {
        return maxMemoryCapacity;
    }

    public void setMaxMemoryCapacity(int maxMemoryCapacity) {
        this.maxMemoryCapacity = maxMemoryCapacity;
    }

    public int getMemorySlots() {
        return memorySlots;
    }

    public void setMemorySlots(int memorySlots) {
        this.memorySlots = memorySlots;
    }

    public boolean isRamDualChannel() {
        return ramDualChannel;
    }

    public void setRamDualChannel(boolean ramDualChannel) {
        this.ramDualChannel = ramDualChannel;
    }

    public String getPcieVersion() {
        return pcieVersion;
    }

    public void setPcieVersion(String pcieVersion) {
        this.pcieVersion = pcieVersion;
    }

    public int getM2Slots() {
        return m2Slots;
    }

    public void setM2Slots(int m2Slots) {
        this.m2Slots = m2Slots;
    }

    public String getM2PcieVersion() {
        return m2PcieVersion;
    }

    public void setM2PcieVersion(String m2PcieVersion) {
        this.m2PcieVersion = m2PcieVersion;
    }

    public String getVideoPorts() {
        return videoPorts;
    }

    public void setVideoPorts(String videoPorts) {
        this.videoPorts = videoPorts;
    }

    public int getSataPorts() {
        return sataPorts;
    }

    public void setSataPorts(int sataPorts) {
        this.sataPorts = sataPorts;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getAudioChipset() {
        return audioChipset;
    }

    public void setAudioChipset(String audioChipset) {
        this.audioChipset = audioChipset;
    }

    public boolean isRgbHeader() {
        return rgbHeader;
    }

    public void setRgbHeader(boolean rgbHeader) {
        this.rgbHeader = rgbHeader;
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
