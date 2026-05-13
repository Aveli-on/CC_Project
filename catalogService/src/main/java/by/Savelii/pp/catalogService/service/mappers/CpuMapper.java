package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.CpuRequest;
import by.Savelii.pp.catalogService.dto.CpuResponse;
import by.Savelii.pp.catalogService.repository.entity.Cpu;

import java.util.HashMap;
import java.util.Map;

public class CpuMapper {
    public static Cpu toEntity(CpuRequest cpuRequest){
        Cpu cpu=new Cpu();
        cpu.setBrand(cpuRequest.getBrand());
        cpu.setModel(cpuRequest.getModel());
        cpu.setSocket(cpuRequest.getSocket());
        cpu.setCores(cpuRequest.getCores());
        cpu.setThreads(cpuRequest.getThreads());
        cpu.setBaseClock(cpuRequest.getBaseClock());
        cpu.setBoostClock(cpuRequest.getBoostClock());
        cpu.setTdp(cpuRequest.getTdp());
        cpu.setIntegratedGraphics(cpuRequest.getIntegratedGraphics());
        cpu.setMaxMemorySpeed(cpuRequest.getMaxMemorySpeed());
        cpu.setMemoryType(cpuRequest.getMemoryType());
        cpu.setPcieVersion(cpuRequest.getPcieVersion());
        cpu.setPackaging(cpuRequest.getPackaging());
        cpu.setPrice(cpuRequest.getPrice());
        cpu.setCurrency(cpuRequest.getCurrency());
        cpu.setStockAvailable(cpuRequest.isStockAvailable());
        return cpu;
    }
    public static void toUpdateEntity(Cpu cpu,CpuRequest cpuRequest){
        cpu.setBrand(cpuRequest.getBrand());
        cpu.setModel(cpuRequest.getModel());
        cpu.setSocket(cpuRequest.getSocket());
        cpu.setCores(cpuRequest.getCores());
        cpu.setThreads(cpuRequest.getThreads());
        cpu.setBaseClock(cpuRequest.getBaseClock());
        cpu.setBoostClock(cpuRequest.getBoostClock());
        cpu.setTdp(cpuRequest.getTdp());
        cpu.setIntegratedGraphics(cpuRequest.getIntegratedGraphics());
        cpu.setMaxMemorySpeed(cpuRequest.getMaxMemorySpeed());
        cpu.setMemoryType(cpuRequest.getMemoryType());
        cpu.setPcieVersion(cpuRequest.getPcieVersion());
        cpu.setPackaging(cpuRequest.getPackaging());
        cpu.setPrice(cpuRequest.getPrice());
        cpu.setCurrency(cpuRequest.getCurrency());
        cpu.setStockAvailable(cpuRequest.isStockAvailable());
    }
    public static CpuResponse toResponse(Cpu cpu){
        CpuResponse cpuResponse =new CpuResponse();
        cpuResponse.setId(cpu.getId());
        cpuResponse.setBrand(cpu.getBrand());
        cpuResponse.setModel(cpu.getModel());
        cpuResponse.setSocket(cpu.getSocket());
        cpuResponse.setCores(cpu.getCores());
        cpuResponse.setThreads(cpu.getThreads());
        cpuResponse.setBaseClock(cpu.getBaseClock());
        cpuResponse.setBoostClock(cpu.getBoostClock());
        cpuResponse.setTdp(cpu.getTdp());
        cpuResponse.setIntegratedGraphics(cpu.getIntegratedGraphics());
        cpuResponse.setMaxMemorySpeed(cpu.getMaxMemorySpeed());
        cpuResponse.setMemoryType(cpu.getMemoryType());
        cpuResponse.setPcieVersion(cpu.getPcieVersion());
        cpuResponse.setPackaging(cpu.getPackaging());
        cpuResponse.setPrice(cpu.getPrice());
        cpuResponse.setCurrency(cpu.getCurrency());
        cpuResponse.setStockAvailable(cpu.isStockAvailable());
        cpuResponse.setCreatedAt(cpu.getCreatedAt());
        cpuResponse.setUpdatedAt(cpu.getUpdatedAt());
        return cpuResponse;
    }
    public static Map<String,String> toSpecificationsMap(Cpu cpu){
        Map<String,String> map=new HashMap<>();
        map.put("socket", cpu.getSocket());
        map.put("tdp", String.valueOf(cpu.getTdp()));
        map.put("integratedGraphics",cpu.getIntegratedGraphics());
        map.put("memoryType",cpu.getMemoryType());
        map.put("maxMemorySpeed",String.valueOf(cpu.getMaxMemorySpeed()));
        map.put("pcieVersion",cpu.getPcieVersion());
        map.put("packaging",cpu.getPackaging());
        return map;
    }
}
