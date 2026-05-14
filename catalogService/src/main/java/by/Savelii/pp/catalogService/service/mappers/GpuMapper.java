package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.CpuResponse;
import by.Savelii.pp.catalogService.dto.GpuRequest;
import by.Savelii.pp.catalogService.dto.GpuResponse;
import by.Savelii.pp.catalogService.repository.entity.Gpu;

import java.util.HashMap;
import java.util.Map;

public class GpuMapper {
    public static Gpu toEntity(GpuRequest request){
        Gpu gpu=new Gpu();
        gpu.setBrand(request.getBrand());
        gpu.setModel(request.getModel());
        gpu.setMemorySize(request.getMemorySize());
        gpu.setMemoryType(request.getMemoryType());
        gpu.setCoreClock(request.getCoreClock());
        gpu.setBoostClock(request.getBoostClock());
        gpu.setTdp(request.getTdp());
        gpu.setLength(request.getLength());
        gpu.setWidth(request.getWidth());
        gpu.setHeight(request.getHeight());
        gpu.setPcieVersion(request.getPcieVersion());
        gpu.setPowerConnectors(request.getPowerConnectors());
        gpu.setHdmi(request.getHdmi());
        gpu.setDisplayPort(request.getDisplayPort());
        gpu.setDvi(request.getDvi());
        gpu.setPrice(request.getPrice());
        gpu.setCurrency(request.getCurrency());
        gpu.setStockAvailable(request.isStockAvailable());
        return gpu;
    }
    public static void toUpdateEntity( Gpu gpu,GpuRequest request){
        gpu.setBrand(request.getBrand());
        gpu.setModel(request.getModel());
        gpu.setMemorySize(request.getMemorySize());
        gpu.setMemoryType(request.getMemoryType());
        gpu.setCoreClock(request.getCoreClock());
        gpu.setBoostClock(request.getBoostClock());
        gpu.setTdp(request.getTdp());
        gpu.setLength(request.getLength());
        gpu.setWidth(request.getWidth());
        gpu.setHeight(request.getHeight());
        gpu.setPcieVersion(request.getPcieVersion());
        gpu.setPowerConnectors(request.getPowerConnectors());
        gpu.setHdmi(request.getHdmi());
        gpu.setDisplayPort(request.getDisplayPort());
        gpu.setDvi(request.getDvi());
        gpu.setPrice(request.getPrice());
        gpu.setCurrency(request.getCurrency());
        gpu.setStockAvailable(request.isStockAvailable());
    }
    public static GpuResponse toResponse(Gpu gpu){
        GpuResponse response=new GpuResponse();
        response.setId(response.getId());
        response.setBrand(gpu.getBrand());
        response.setModel(gpu.getModel());
        response.setMemorySize(gpu.getMemorySize());
        response.setMemoryType(gpu.getMemoryType());
        response.setCoreClock(gpu.getCoreClock());
        response.setBoostClock(gpu.getBoostClock());
        response.setTdp(gpu.getTdp());
        response.setLength(gpu.getLength());
        response.setWidth(gpu.getWidth());
        response.setHeight(gpu.getHeight());
        response.setPcieVersion(gpu.getPcieVersion());
        response.setPowerConnectors(gpu.getPowerConnectors());
        response.setHdmi(gpu.getHdmi());
        response.setDisplayPort(gpu.getDisplayPort());
        response.setDvi(gpu.getDvi());
        response.setPrice(gpu.getPrice());
        response.setCurrency(gpu.getCurrency());
        response.setStockAvailable(gpu.isStockAvailable());
        response.setCreatedAt(gpu.getCreatedAt());
        response.setUpdatedAt(gpu.getUpdatedAt());
        return response;
    }
    public static Map<String,String> toSpecificationsMap(Gpu gpu){
        Map<String,String> map=new HashMap<>();
        map.put("tdp", String.valueOf(gpu.getTdp()));
        map.put("length", String.valueOf(gpu.getLength()));
        map.put("pcieVersion", gpu.getPcieVersion());
        map.put("powerConnectors", gpu.getPowerConnectors());
        return map;
    }
}
