package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.FanRequest;
import by.Savelii.pp.catalogService.dto.FanResponse;
import by.Savelii.pp.catalogService.repository.entity.Fan;

import java.util.HashMap;
import java.util.Map;

public class FanMapper {
    public static Fan toEntity(FanRequest request) {
        Fan fan = new Fan();
        fan.setBrand(request.getBrand());
        fan.setModel(request.getModel());
        fan.setSize(request.getSize());
        fan.setRpm(request.getRpm());
        fan.setAirflow(request.getAirflow());
        fan.setNoise(request.getNoise());
        fan.setConnector(request.getConnector());
        fan.setPrice(request.getPrice());
        fan.setCurrency(request.getCurrency());
        fan.setStockAvailable(request.isStockAvailable());
        return  fan;
    }

    public static void toUpdateEntity(Fan fan,FanRequest request) {
        fan.setBrand(request.getBrand());
        fan.setModel(request.getModel());
        fan.setSize(request.getSize());
        fan.setRpm(request.getRpm());
        fan.setAirflow(request.getAirflow());
        fan.setNoise(request.getNoise());
        fan.setConnector(request.getConnector());
        fan.setPrice(request.getPrice());
        fan.setCurrency(request.getCurrency());
        fan.setStockAvailable(request.isStockAvailable());
    }

    public static FanResponse toResponse(Fan fan) {
        FanResponse fanResponse = new FanResponse();
        fanResponse.setId(fan.getId());
        fanResponse.setBrand(fan.getBrand());
        fanResponse.setModel(fan.getModel());
        fanResponse.setSize(fan.getSize());
        fanResponse.setRpm(fan.getRpm());
        fanResponse.setAirflow(fan.getAirflow());
        fanResponse.setNoise(fan.getNoise());
        fanResponse.setConnector(fan.getConnector());
        fanResponse.setPrice(fan.getPrice());
        fanResponse.setCurrency(fan.getCurrency());
        fanResponse.setStockAvailable(fan.isStockAvailable());
        fanResponse.setCreatedAt(fan.getCreatedAt());
        fanResponse.setUpdatedAt(fan.getUpdatedAt());
        return fanResponse;
    }

    public static Map<String, String> toSpecificationsMap(Fan fan) {
        Map<String, String> map = new HashMap<>();
        map.put("size", String.valueOf(fan.getSize()));
        map.put("connector", fan.getConnector() );

        return map;
    }
}
