package by.Savelii.pp.catalogService.service.mappers;

import by.Savelii.pp.catalogService.dto.StorageRequest;
import by.Savelii.pp.catalogService.dto.StorageResponse;
import by.Savelii.pp.catalogService.repository.entity.Storage;

import java.util.HashMap;
import java.util.Map;

public class StorageMapper {
    public static Storage toEntity(StorageRequest request){
        Storage storage=new Storage();
        storage.setBrand(request.getBrand());
        storage.setModel(request.getModel());
        storage.setType(request.getType());
        storage.setCapacity(request.getCapacity());
        storage.setStorageInterface(request.getStorageInterface());
        storage.setFormFactor(request.getFormFactor());
        storage.setMaxReadSpeed(request.getMaxReadSpeed());
        storage.setMaxWriteSpeed(request.getMaxWriteSpeed());
        storage.setTdp(request.getTdp());
        storage.setPrice(request.getPrice());
        storage.setCurrency(request.getCurrency());
        storage.setStockAvailable(request.isStockAvailable());

        return storage;
    }
    public static void toUpdateEntity( Storage storage ,StorageRequest request){
        storage.setBrand(request.getBrand());
        storage.setModel(request.getModel());
        storage.setType(request.getType());
        storage.setCapacity(request.getCapacity());
        storage.setStorageInterface(request.getStorageInterface());
        storage.setFormFactor(request.getFormFactor());
        storage.setMaxReadSpeed(request.getMaxReadSpeed());
        storage.setMaxWriteSpeed(request.getMaxWriteSpeed());
        storage.setTdp(request.getTdp());
        storage.setPrice(request.getPrice());
        storage.setCurrency(request.getCurrency());
        storage.setStockAvailable(request.isStockAvailable());
    }
    public static StorageResponse toResponse(Storage storage){
        StorageResponse storageResponse=new StorageResponse();
        storageResponse.setId(storage.getId());
        storageResponse.setBrand(storage.getBrand());
        storageResponse.setModel(storage.getModel());
        storageResponse.setType(storage.getType());
        storageResponse.setCapacity(storage.getCapacity());
        storageResponse.setStorageInterface(storage.getStorageInterface());
        storageResponse.setFormFactor(storage.getFormFactor());
        storageResponse.setMaxReadSpeed(storage.getMaxReadSpeed());
        storageResponse.setMaxWriteSpeed(storage.getMaxWriteSpeed());
        storageResponse.setTdp(storage.getTdp());
        storageResponse.setPrice(storage.getPrice());
        storageResponse.setCurrency(storage.getCurrency());
        storageResponse.setStockAvailable(storage.isStockAvailable());
        storageResponse.setCreatedAt(storage.getCreatedAt());
        storageResponse.setUpdatedAt(storage.getUpdatedAt());

        return storageResponse;
    }
    public static Map<String,String> toSpecificationsMap(Storage storage){
        Map<String,String> map=new HashMap<>();
        map.put("type", storage.getType() );
        map.put("storageInterface", storage.getStorageInterface());
        map.put("formFactor", storage.getFormFactor());

        return map;
    }
}
