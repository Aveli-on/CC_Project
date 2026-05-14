package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.CoolerRequest;
import by.Savelii.pp.catalogService.dto.CoolerResponse;
import by.Savelii.pp.catalogService.repository.entity.Cooler;

import java.util.HashMap;
import java.util.Map;

public class CoolerMapper {
    public static Cooler toEntity(CoolerRequest request) {
        Cooler cooler = new Cooler();
        cooler.setBrand(request.getBrand());
        cooler.setModel(request.getModel());
        cooler.setType(request.getType());
        cooler.setSupportedSockets(request.getSupportedSockets());
        cooler.setTdp(request.getTdp());
        cooler.setHeight(request.getHeight());
        cooler.setRadiatorSize(request.getRadiatorSize());
        cooler.setPrice(request.getPrice());
        cooler.setCurrency(request.getCurrency());
        cooler.setStockAvailable(request.isStockAvailable());
        return cooler;
    }

    public static void toUpdateEntity(Cooler cooler, CoolerRequest request) {
        cooler.setBrand(request.getBrand());
        cooler.setModel(request.getModel());
        cooler.setType(request.getType());
        cooler.setSupportedSockets(request.getSupportedSockets());
        cooler.setTdp(request.getTdp());
        cooler.setHeight(request.getHeight());
        cooler.setRadiatorSize(request.getRadiatorSize());
        cooler.setPrice(request.getPrice());
        cooler.setCurrency(request.getCurrency());
        cooler.setStockAvailable(request.isStockAvailable());
    }

    public static CoolerResponse toResponse(Cooler cooler) {
        CoolerResponse coolerResponse = new CoolerResponse();
        coolerResponse.setId(cooler.getId());
        coolerResponse.setBrand(cooler.getBrand());
        coolerResponse.setModel(cooler.getModel());
        coolerResponse.setType(cooler.getType());
        coolerResponse.setSupportedSockets(cooler.getSupportedSockets());
        coolerResponse.setTdp(cooler.getTdp());
        coolerResponse.setHeight(cooler.getHeight());
        coolerResponse.setRadiatorSize(cooler.getRadiatorSize());
        coolerResponse.setPrice(cooler.getPrice());
        coolerResponse.setCurrency(cooler.getCurrency());
        coolerResponse.setStockAvailable(cooler.isStockAvailable());
        coolerResponse.setCreatedAt(cooler.getCreatedAt());
        coolerResponse.setUpdatedAt(cooler.getUpdatedAt());
        return coolerResponse;
    }

    public static Map<String, String> toSpecificationsMap(Cooler cooler) {
        Map<String, String> map = new HashMap<>();
        map.put("type", cooler.getType());
        map.put("supportedSockets", cooler.getSupportedSockets() );
        map.put("tdp", String.valueOf(cooler.getTdp()));
        map.put("height", String.valueOf(cooler.getHeight()));
        map.put("radiatorSize", String.valueOf(cooler.getRadiatorSize()));
        return map;
    }
}
