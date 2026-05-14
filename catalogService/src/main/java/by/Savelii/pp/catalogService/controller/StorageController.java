package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.dto.StorageRequest;
import by.Savelii.pp.catalogService.dto.StorageResponse;
import by.Savelii.pp.catalogService.service.StorageService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
    private final StorageService storageService ;
    private final Logger LOGGER= LoggerFactory.getLogger(StorageController.class);

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<StorageResponse> create(@Valid @RequestBody StorageRequest request){
        LOGGER.info("Request for create storage : {} - {}",request.getBrand(),request.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(storageService.create(request));
    }
    @GetMapping("{id}")
    public ResponseEntity<StorageResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search storage, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(storageService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<StorageResponse>> getAll(){
        LOGGER.info("Request for search all storage");
        return ResponseEntity.status(HttpStatus.OK).body(storageService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete storage, id: {}",id);
        storageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<StorageResponse> updateById(@PathVariable Long id ,@Valid @RequestBody StorageRequest request ){
        LOGGER.info("Request for update storage, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(storageService.updateById(id,request));
    }
}

