package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.GpuRequest;
import by.Savelii.pp.catalogService.dto.GpuResponse;
import by.Savelii.pp.catalogService.dto.PsuRequest;
import by.Savelii.pp.catalogService.dto.PsuResponse;
import by.Savelii.pp.catalogService.repository.entity.Gpu;
import by.Savelii.pp.catalogService.repository.entity.Psu;

import java.util.HashMap;
import java.util.Map;

public class PsuMapper {

        public static Psu toEntity(PsuRequest request){
            Psu psu=new Psu();
            psu.setBrand(request.getBrand());
            psu.setModel(request.getModel());
            psu.setWattage(request.getWattage());
            psu.setFormFactor(request.getFormFactor());
            psu.setModular(request.getModular());
            psu.setEfficiencyRating(request.getEfficiencyRating());
            psu.setPcie6plus2(request.getPcie6plus2());
            psu.setPcie8pin(request.getPcie8pin());
            psu.setSata(request.getSata());
            psu.setMolex(request.getMolex());
            psu.setLength(request.getLength());
            psu.setPrice(request.getPrice());
            psu.setCurrency(request.getCurrency());
            psu.setStockAvailable(request.isStockAvailable());
            return psu;
        }
        public static void toUpdateEntity(Psu psu ,PsuRequest request){
            psu.setBrand(request.getBrand());
            psu.setModel(request.getModel());
            psu.setWattage(request.getWattage());
            psu.setFormFactor(request.getFormFactor());
            psu.setModular(request.getModular());
            psu.setEfficiencyRating(request.getEfficiencyRating());
            psu.setPcie6plus2(request.getPcie6plus2());
            psu.setPcie8pin(request.getPcie8pin());
            psu.setSata(request.getSata());
            psu.setMolex(request.getMolex());
            psu.setLength(request.getLength());
            psu.setPrice(request.getPrice());
            psu.setCurrency(request.getCurrency());
            psu.setStockAvailable(request.isStockAvailable());
        }
        public static PsuResponse toResponse(Psu psu){
            PsuResponse psuResponse=new PsuResponse();
            psuResponse.setId(psu.getId());
            psuResponse.setBrand(psu.getBrand());
            psuResponse.setModel(psu.getModel());
            psuResponse.setWattage(psu.getWattage());
            psuResponse.setFormFactor(psu.getFormFactor());
            psuResponse.setModular(psu.getModular());
            psuResponse.setEfficiencyRating(psu.getEfficiencyRating());
            psuResponse.setPcie6plus2(psu.getPcie6plus2());
            psuResponse.setPcie8pin(psu.getPcie8pin());
            psuResponse.setSata(psu.getSata());
            psuResponse.setMolex(psu.getMolex());
            psuResponse.setLength(psu.getLength());
            psuResponse.setPrice(psu.getPrice());
            psuResponse.setCurrency(psu.getCurrency());
            psuResponse.setStockAvailable(psu.isStockAvailable());
            psuResponse.setCreatedAt(psu.getCreatedAt());
            psuResponse.setUpdatedAt(psu.getUpdatedAt());
            return psuResponse;
        }
        public static Map<String,String> toSpecificationsMap(Psu psu){
            Map<String,String> map=new HashMap<>();
            map.put("wattage", String.valueOf(psu.getWattage()));
            map.put("formFactor", psu.getFormFactor());
            map.put("pcie6plus2", String.valueOf(psu.getPcie6plus2()));
            map.put("pcie8pin", String.valueOf(psu.getPcie8pin()));
            map.put("sata", String.valueOf(psu.getSata()));
            map.put("molex", String.valueOf(psu.getMolex()));
            map.put("length", String.valueOf(psu.getLength()));
            return map;
        }


}
