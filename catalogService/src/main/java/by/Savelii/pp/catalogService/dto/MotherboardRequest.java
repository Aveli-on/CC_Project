package by.Savelii.pp.catalogService.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class MotherboardRequest {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String socket;
    @NotBlank
    private String chipset;
    @Pattern(regexp = "Micro-ATX|Mini-ATX|Mini-ITX|ATX")
    private String formFactor;
    @Pattern(regexp = "DDR\\d")
    private String memoryType;
    @Positive
    private int maxMemorySpeed;
    @Positive
    private int maxMemoryCapacity;
    @Positive
    private int memorySlots;
    @NotNull
    private boolean ramDualChannel;
    @Pattern(regexp = "^\\d\\.\\d$")
    private String pcieVersion;
    @Positive
    private int m2Slots;
    @Pattern(regexp = "^\\d\\.\\d$")
    private String m2PcieVersion ;
    @NotBlank
    private String videoPorts  ;
    @Positive
    private int sataPorts   ;
    @Pattern(regexp = "^\\d\\.\\d$")
    private String lan;
    @Pattern(regexp = "^\\d\\.\\d$")
    private String wifi;
    @NotBlank
    private String audioChipset;
    @NotNull
    private boolean rgbHeader   ;
    @Positive
    private BigDecimal price;
    @Size(min = 3,max = 3)
    private String currency;
    @NotNull
    private boolean stockAvailable;

    public MotherboardRequest() {
    }

    public MotherboardRequest(String brand, String model, String socket, String chipset, String formFactor, String memoryType, int maxMemorySpeed, int maxMemoryCapacity, int memorySlots, boolean ramDualChannel, String pcieVersion, int m2Slots, String m2PcieVersion, String videoPorts, int sataPorts, String lan, String wifi, String audioChipset, boolean rgbHeader, BigDecimal price, String currency, boolean stockAvailable) {
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

    public @NotBlank String getSocket() {
        return socket;
    }

    public void setSocket(@NotBlank String socket) {
        this.socket = socket;
    }

    public @NotBlank String getChipset() {
        return chipset;
    }

    public void setChipset(@NotBlank String chipset) {
        this.chipset = chipset;
    }

    public @Pattern(regexp = "Micro-ATX|Mini-ATX|Mini-ITX|ATX") String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(@Pattern(regexp = "Micro-ATX|Mini-ATX|Mini-ITX|ATX") String formFactor) {
        this.formFactor = formFactor;
    }

    public @Pattern(regexp = "DDR\\d") String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(@Pattern(regexp = "DDR\\d") String memoryType) {
        this.memoryType = memoryType;
    }

    @Positive
    public int getMaxMemorySpeed() {
        return maxMemorySpeed;
    }

    public void setMaxMemorySpeed(@Positive int maxMemorySpeed) {
        this.maxMemorySpeed = maxMemorySpeed;
    }

    @Positive
    public int getMaxMemoryCapacity() {
        return maxMemoryCapacity;
    }

    public void setMaxMemoryCapacity(@Positive int maxMemoryCapacity) {
        this.maxMemoryCapacity = maxMemoryCapacity;
    }

    @Positive
    public int getMemorySlots() {
        return memorySlots;
    }

    public void setMemorySlots(@Positive int memorySlots) {
        this.memorySlots = memorySlots;
    }

    @NotNull
    public boolean isRamDualChannel() {
        return ramDualChannel;
    }

    public void setRamDualChannel(@NotNull boolean ramDualChannel) {
        this.ramDualChannel = ramDualChannel;
    }

    public @Pattern(regexp = "^\\d\\.\\d$") String getPcieVersion() {
        return pcieVersion;
    }

    public void setPcieVersion(@Pattern(regexp = "^\\d\\.\\d$") String pcieVersion) {
        this.pcieVersion = pcieVersion;
    }

    @Positive
    public int getM2Slots() {
        return m2Slots;
    }

    public void setM2Slots(@Positive int m2Slots) {
        this.m2Slots = m2Slots;
    }

    public @Pattern(regexp = "^\\d\\.\\d$") String getM2PcieVersion() {
        return m2PcieVersion;
    }

    public void setM2PcieVersion(@Pattern(regexp = "^\\d\\.\\d$") String m2PcieVersion) {
        this.m2PcieVersion = m2PcieVersion;
    }

    public @NotBlank String getVideoPorts() {
        return videoPorts;
    }

    public void setVideoPorts(@NotBlank String videoPorts) {
        this.videoPorts = videoPorts;
    }

    @Positive
    public int getSataPorts() {
        return sataPorts;
    }

    public void setSataPorts(@Positive int sataPorts) {
        this.sataPorts = sataPorts;
    }

    public @Pattern(regexp = "^\\d\\.\\d$") String getLan() {
        return lan;
    }

    public void setLan(@Pattern(regexp = "^\\d\\.\\d$") String lan) {
        this.lan = lan;
    }

    public @Pattern(regexp = "^\\d\\.\\d$") String getWifi() {
        return wifi;
    }

    public void setWifi(@Pattern(regexp = "^\\d\\.\\d$") String wifi) {
        this.wifi = wifi;
    }

    public @NotBlank String getAudioChipset() {
        return audioChipset;
    }

    public void setAudioChipset(@NotBlank String audioChipset) {
        this.audioChipset = audioChipset;
    }

    @NotNull
    public boolean isRgbHeader() {
        return rgbHeader;
    }

    public void setRgbHeader(@NotNull boolean rgbHeader) {
        this.rgbHeader = rgbHeader;
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
