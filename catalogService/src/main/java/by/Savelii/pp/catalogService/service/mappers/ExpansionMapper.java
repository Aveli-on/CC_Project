package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.ExpansionRequest;
import by.Savelii.pp.catalogService.dto.ExpansionResponse;
import by.Savelii.pp.catalogService.repository.entity.Expansion;

import java.util.HashMap;
import java.util.Map;

public class ExpansionMapper {
    public static Expansion toEntity(ExpansionRequest request){
        Expansion expansion=new Expansion();
        expansion.setBrand(request.getBrand());
        expansion.setModel(request.getModel());
        expansion.setType(request.getType());
        expansion.setExpansionInterface(request.getExpansionInterface());
        expansion.setSlotsRequired(request.getSlotsRequired());
        expansion.setPrice(request.getPrice());
        expansion.setCurrency(request.getCurrency());
        expansion.setStockAvailable(request.isStockAvailable());
        return expansion;
    }
    public static void toUpdateEntity(Expansion expansion ,ExpansionRequest request){
        expansion.setBrand(request.getBrand());
        expansion.setModel(request.getModel());
        expansion.setType(request.getType());
        expansion.setExpansionInterface(request.getExpansionInterface());
        expansion.setSlotsRequired(request.getSlotsRequired());
        expansion.setPrice(request.getPrice());
        expansion.setCurrency(request.getCurrency());
        expansion.setStockAvailable(request.isStockAvailable());
    }
    public static ExpansionResponse toResponse(Expansion expansion){
        ExpansionResponse expansionResponse=new ExpansionResponse();
        expansionResponse.setId(expansion.getId());
        expansionResponse.setBrand(expansion.getBrand());
        expansionResponse.setModel(expansion.getModel());
        expansionResponse.setType(expansion.getType());
        expansionResponse.setExpansionInterface(expansion.getExpansionInterface());
        expansionResponse.setSlotsRequired(expansion.getSlotsRequired());
        expansionResponse.setPrice(expansion.getPrice());
        expansionResponse.setCurrency(expansion.getCurrency());
        expansionResponse.setStockAvailable(expansion.isStockAvailable());
        expansionResponse.setCreatedAt(expansion.getCreatedAt());
        expansionResponse.setUpdatedAt(expansion.getUpdatedAt());

        return expansionResponse;
    }
    public static Map<String,String> toSpecificationsMap(Expansion expansion){
        Map<String,String> map=new HashMap<>();
        map.put("expansionInterface", expansion.getExpansionInterface());
        map.put("slotsRequired", String.valueOf(expansion.getSlotsRequired()));

        return map;
    }
}
