package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.RamRequest;
import by.Savelii.pp.catalogService.dto.RamResponse;
import by.Savelii.pp.catalogService.repository.entity.Ram;

import java.util.HashMap;
import java.util.Map;

public class RamMapper {
    public static Ram toEntity(RamRequest request){
        Ram ram=new Ram();
        ram.setBrand(request.getBrand());
        ram.setModel(request.getModel());
        ram.setMemoryType(request.getMemoryType());
        ram.setCapacity(request.getCapacity());
        ram.setSpeed(request.getSpeed());
        ram.setLatency(request.getLatency());
        ram.setKit(request.getKit());
        ram.setVoltage(request.getVoltage());
        ram.setPrice(request.getPrice());
        ram.setCurrency(request.getCurrency());
        ram.setStockAvailable(request.isStockAvailable());
        return ram;
    }
    public static void toUpdateEntity(Ram ram ,RamRequest request){
        ram.setBrand(request.getBrand());
        ram.setModel(request.getModel());
        ram.setMemoryType(request.getMemoryType());
        ram.setCapacity(request.getCapacity());
        ram.setSpeed(request.getSpeed());
        ram.setLatency(request.getLatency());
        ram.setKit(request.getKit());
        ram.setVoltage(request.getVoltage());
        ram.setPrice(request.getPrice());
        ram.setCurrency(request.getCurrency());
        ram.setStockAvailable(request.isStockAvailable());
    }
    public static RamResponse toResponse(Ram ram){
        RamResponse ramResponse=new RamResponse();
        ramResponse.setId(ram.getId());
        ramResponse.setBrand(ram.getBrand());
        ramResponse.setModel(ram.getModel());
        ramResponse.setMemoryType(ram.getMemoryType());
        ramResponse.setCapacity(ram.getCapacity());
        ramResponse.setSpeed(ram.getSpeed());
        ramResponse.setLatency(ram.getLatency());
        ramResponse.setKit(ram.getKit());
        ramResponse.setVoltage(ram.getVoltage());
        ramResponse.setPrice(ram.getPrice());
        ramResponse.setCurrency(ram.getCurrency());
        ramResponse.setStockAvailable(ram.isStockAvailable());
        ramResponse.setCreatedAt(ram.getCreatedAt());
        ramResponse.setUpdatedAt(ram.getUpdatedAt());
        return ramResponse;
    }
    public static Map<String,String> toSpecificationsMap(Ram ram){
        Map<String,String> map=new HashMap<>();
        map.put("memoryType", ram.getMemoryType());
        map.put("capacity", String.valueOf(ram.getCapacity()));
        map.put("speed", String.valueOf(ram.getSpeed()));
        map.put("latency", ram.getLatency());
        map.put("kit", String.valueOf(ram.getKit()));
        map.put("voltage", String.valueOf(ram.getVoltage()));

        return map;
    }
}
