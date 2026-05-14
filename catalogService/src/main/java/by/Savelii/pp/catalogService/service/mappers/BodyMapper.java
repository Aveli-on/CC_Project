package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.BodyRequest;
import by.Savelii.pp.catalogService.dto.BodyResponse;
import by.Savelii.pp.catalogService.repository.entity.Body;

import java.util.HashMap;
import java.util.Map;

public class BodyMapper {
    public static Body toEntity(BodyRequest request){
        Body body=new Body();

        body.setBrand(request.getBrand());
        body.setModel(request.getModel());
        body.setFormFactor(request.getFormFactor());
        body.setMaxGpuLength(request.getMaxGpuLength());
        body.setMaxCpuCoolerHeight(request.getMaxCpuCoolerHeight());
        body.setMaxPsuLength(request.getMaxPsuLength());
        body.setDriveBays35(request.getDriveBays35());
        body.setDriveBays25(request.getDriveBays25());
        body.setExpansionSlots(request.getExpansionSlots());
        body.setFanMounts(request.getFanMounts());
        body.setPrice(request.getPrice());
        body.setCurrency(request.getCurrency());
        body.setStockAvailable(request.isStockAvailable());
        return body;
    }
    public static void toUpdateEntity(Body body ,BodyRequest request){
        body.setBrand(request.getBrand());
        body.setModel(request.getModel());
        body.setFormFactor(request.getFormFactor());
        body.setMaxGpuLength(request.getMaxGpuLength());
        body.setMaxCpuCoolerHeight(request.getMaxCpuCoolerHeight());
        body.setMaxPsuLength(request.getMaxPsuLength());
        body.setDriveBays35(request.getDriveBays35());
        body.setDriveBays25(request.getDriveBays25());
        body.setExpansionSlots(request.getExpansionSlots());
        body.setFanMounts(request.getFanMounts());
        body.setPrice(request.getPrice());
        body.setCurrency(request.getCurrency());
        body.setStockAvailable(request.isStockAvailable());
    }
    public static BodyResponse toResponse(Body body){
        BodyResponse bodyResponse=new BodyResponse();
        bodyResponse.setId(body.getId());
        bodyResponse.setBrand(body.getBrand());
        bodyResponse.setModel(body.getModel());
        bodyResponse.setFormFactor(body.getFormFactor());
        bodyResponse.setMaxGpuLength(body.getMaxGpuLength());
        bodyResponse.setMaxCpuCoolerHeight(body.getMaxCpuCoolerHeight());
        bodyResponse.setMaxPsuLength(body.getMaxPsuLength());
        bodyResponse.setDriveBays35(body.getDriveBays35());
        bodyResponse.setDriveBays25(body.getDriveBays25());
        bodyResponse.setExpansionSlots(body.getExpansionSlots());
        bodyResponse.setFanMounts(body.getFanMounts());
        bodyResponse.setPrice(body.getPrice());
        bodyResponse.setCurrency(body.getCurrency());
        bodyResponse.setStockAvailable(body.isStockAvailable());
        bodyResponse.setCreatedAt(body.getCreatedAt());
        bodyResponse.setUpdatedAt(body.getUpdatedAt());
        return bodyResponse;
    }
    public static Map<String,String> toSpecificationsMap(Body body){
        Map<String,String> map=new HashMap<>();
        map.put("formFactor",body.getFormFactor() );
        map.put("maxGpuLength", String.valueOf(body.getMaxGpuLength()));
        map.put("maxCpuCoolerHeight", String.valueOf(body.getMaxCpuCoolerHeight()));
        map.put("maxPsuLength", String.valueOf(body.getMaxPsuLength()));
        map.put("driveBays35", String.valueOf(body.getDriveBays35()));
        map.put("driveBays25", String.valueOf(body.getDriveBays25()));
        map.put("expansionSlots", String.valueOf(body.getExpansionSlots()));
        map.put("fanMounts", body.getFanMounts());

        return map;
    }
}
