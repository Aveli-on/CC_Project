package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.GpuRequest;
import by.Savelii.pp.catalogService.dto.GpuResponse;
import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.service.GpuService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gpu")
public class GpuController {
    private final GpuService gpuService  ;
    private final Logger LOGGER= LoggerFactory.getLogger(GpuController.class);

    public GpuController(GpuService gpuService) {
        this.gpuService = gpuService;
    }

    @PostMapping
    public ResponseEntity<GpuResponse> create(@Valid @RequestBody GpuRequest gpuRequest){
        LOGGER.info("Request for create gpu : {} - {}",gpuRequest.getBrand(),gpuRequest.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(gpuService.create(gpuRequest));
    }
    @GetMapping("{id}")
    public ResponseEntity<GpuResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search gpu, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(gpuService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<GpuResponse>> getAll(){
        LOGGER.info("Request for search all gpu");
        return ResponseEntity.status(HttpStatus.OK).body(gpuService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete gpu, id: {}",id);
        gpuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<GpuResponse> updateById(@PathVariable Long id ,@Valid @RequestBody GpuRequest gpuRequest ){
        LOGGER.info("Request for update gpu, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(gpuService.updateById(id,gpuRequest));
    }
}

