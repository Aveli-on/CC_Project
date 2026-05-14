package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.MotherboardRequest;
import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.repository.entity.Motherboard;

import java.util.HashMap;
import java.util.Map;

public class MotherboardMapper {
    public static Motherboard toEntity(MotherboardRequest request){
        Motherboard motherboard=new Motherboard();
        motherboard.setBrand(request.getBrand());
        motherboard.setModel(request.getModel());
        motherboard.setSocket(request.getSocket());
        motherboard.setChipset(request.getChipset());
        motherboard.setFormFactor(request.getFormFactor());
        motherboard.setMemoryType(request.getMemoryType());
        motherboard.setMaxMemorySpeed(request.getMaxMemorySpeed());
        motherboard.setMaxMemoryCapacity(request.getMaxMemoryCapacity());
        motherboard.setMemorySlots(request.getMemorySlots());
        motherboard.setRamDualChannel(request.isRamDualChannel());
        motherboard.setPcieVersion(request.getPcieVersion());
        motherboard.setM2Slots(request.getM2Slots());
        motherboard.setM2PcieVersion(request.getM2PcieVersion());
        motherboard.setVideoPorts(request.getVideoPorts());
        motherboard.setSataPorts(request.getSataPorts());
        motherboard.setLan(request.getLan());
        motherboard.setWifi(request.getWifi());
        motherboard.setAudioChipset(request.getAudioChipset());
        motherboard.setRgbHeader(request.isRgbHeader());
        motherboard.setPrice(request.getPrice());
        motherboard.setCurrency(request.getCurrency());
        motherboard.setStockAvailable(request.isStockAvailable());
        return motherboard;
    }
    public static void toUpdateEntity(Motherboard motherboard,MotherboardRequest request){
        motherboard.setBrand(request.getBrand());
        motherboard.setModel(request.getModel());
        motherboard.setSocket(request.getSocket());
        motherboard.setChipset(request.getChipset());
        motherboard.setFormFactor(request.getFormFactor());
        motherboard.setMemoryType(request.getMemoryType());
        motherboard.setMaxMemorySpeed(request.getMaxMemorySpeed());
        motherboard.setMaxMemoryCapacity(request.getMaxMemoryCapacity());
        motherboard.setMemorySlots(request.getMemorySlots());
        motherboard.setRamDualChannel(request.isRamDualChannel());
        motherboard.setPcieVersion(request.getPcieVersion());
        motherboard.setM2Slots(request.getM2Slots());
        motherboard.setM2PcieVersion(request.getM2PcieVersion());
        motherboard.setVideoPorts(request.getVideoPorts());
        motherboard.setSataPorts(request.getSataPorts());
        motherboard.setLan(request.getLan());
        motherboard.setWifi(request.getWifi());
        motherboard.setAudioChipset(request.getAudioChipset());
        motherboard.setRgbHeader(request.isRgbHeader());
        motherboard.setPrice(request.getPrice());
        motherboard.setCurrency(request.getCurrency());
        motherboard.setStockAvailable(request.isStockAvailable());
    }
    public static MotherboardResponse toResponse(Motherboard motherboard){
        MotherboardResponse response =new MotherboardResponse();
        response.setId(motherboard.getId());
        response.setBrand(motherboard.getBrand());
        response.setModel(motherboard.getModel());
        response.setSocket(motherboard.getSocket());
        response.setChipset(motherboard.getChipset());
        response.setFormFactor(motherboard.getFormFactor());
        response.setMemoryType(motherboard.getMemoryType());
        response.setMaxMemorySpeed(motherboard.getMaxMemorySpeed());
        response.setMaxMemoryCapacity(motherboard.getMaxMemoryCapacity());
        response.setMemorySlots(motherboard.getMemorySlots());
        response.setRamDualChannel(motherboard.isRamDualChannel());
        response.setPcieVersion(motherboard.getPcieVersion());
        response.setM2Slots(motherboard.getM2Slots());
        response.setM2PcieVersion(motherboard.getM2PcieVersion());
        response.setVideoPorts(motherboard.getVideoPorts());
        response.setSataPorts(motherboard.getSataPorts());
        response.setLan(motherboard.getLan());
        response.setWifi(motherboard.getWifi());
        response.setAudioChipset(motherboard.getAudioChipset());
        response.setRgbHeader(motherboard.isRgbHeader());
        response.setPrice(motherboard.getPrice());
        response.setCurrency(motherboard.getCurrency());
        response.setStockAvailable(motherboard.isStockAvailable());
        response.setCreatedAt(motherboard.getCreatedAt());
        response.setUpdatedAt(motherboard.getUpdatedAt());
        return response;
    }
    public static Map<String,String> toSpecificationsMap(Motherboard motherboard ){
        Map<String,String> specifications=new HashMap<>();
        specifications.put("socket",motherboard.getSocket());
        specifications.put("chipset",motherboard.getChipset());
        specifications.put("formFactor",motherboard.getFormFactor());
        specifications.put("memoryType",motherboard.getMemoryType());
        specifications.put("maxMemorySpeed", String.valueOf(motherboard.getMaxMemorySpeed()));
        specifications.put("maxMemoryCapacity", String.valueOf(motherboard.getMaxMemoryCapacity()));
        specifications.put("memorySlots", String.valueOf(motherboard.getMemorySlots()));
        specifications.put("ramDualChannel", String.valueOf(motherboard.isRamDualChannel()));
        specifications.put("pcieVersion",motherboard.getPcieVersion());
        specifications.put("m2Slots", String.valueOf(motherboard.getM2Slots()));
        specifications.put("m2PcieVersion",motherboard.getM2PcieVersion());
        specifications.put("videoPorts",motherboard.getVideoPorts());
        specifications.put("sataPorts", String.valueOf(motherboard.getSataPorts()));
        specifications.put("lan",motherboard.getLan());
        specifications.put("wifi",motherboard.getWifi());
        return specifications;
    }
}
