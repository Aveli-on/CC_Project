package by.Savelii.pp.compatibilityService.dto;

import jakarta.validation.constraints.Positive;

public class CompatibilityRequest {
    @Positive
    Long cpuId;
    @Positive
    Long gpuId;
    @Positive
    Long ramId;
    @Positive
    Long motherboardId;
    @Positive
    Long psuId;
    @Positive
    Long m2Id;
    @Positive
    Long bodyId;
    @Positive
    Long coolerId;
    @Positive
    Long expansionCardId;
    @Positive
    Long fanId;

    public CompatibilityRequest() {
    }

    public CompatibilityRequest(Long cpuId, Long gpuId, Long ramId, Long motherboardId, Long psuId, Long m2Id, Long bodyId, Long coolerId, Long expansionCardId, Long fanId) {
        this.cpuId = cpuId;
        this.gpuId = gpuId;
        this.ramId = ramId;
        this.motherboardId = motherboardId;
        this.psuId = psuId;
        this.m2Id = m2Id;
        this.bodyId = bodyId;
        this.coolerId = coolerId;
        this.expansionCardId = expansionCardId;
        this.fanId = fanId;
    }

    public @Positive Long getCpuId() {
        return cpuId;
    }

    public void setCpuId(@Positive Long cpuId) {
        this.cpuId = cpuId;
    }

    public @Positive Long getGpuId() {
        return gpuId;
    }

    public void setGpuId(@Positive Long gpuId) {
        this.gpuId = gpuId;
    }

    public @Positive Long getRamId() {
        return ramId;
    }

    public void setRamId(@Positive Long ramId) {
        this.ramId = ramId;
    }

    public @Positive Long getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(@Positive Long motherboardId) {
        this.motherboardId = motherboardId;
    }

    public @Positive Long getPsuId() {
        return psuId;
    }

    public void setPsuId(@Positive Long psuId) {
        this.psuId = psuId;
    }

    public @Positive Long getM2Id() {
        return m2Id;
    }

    public void setM2Id(@Positive Long m2Id) {
        this.m2Id = m2Id;
    }

    public @Positive Long getBodyId() {
        return bodyId;
    }

    public void setBodyId(@Positive Long bodyId) {
        this.bodyId = bodyId;
    }

    public @Positive Long getCoolerId() {
        return coolerId;
    }

    public void setCoolerId(@Positive Long coolerId) {
        this.coolerId = coolerId;
    }

    public @Positive Long getExpansionCardId() {
        return expansionCardId;
    }

    public void setExpansionCardId(@Positive Long expansionCardId) {
        this.expansionCardId = expansionCardId;
    }

    public @Positive Long getFanId() {
        return fanId;
    }

    public void setFanId(@Positive Long fanId) {
        this.fanId = fanId;
    }
}
