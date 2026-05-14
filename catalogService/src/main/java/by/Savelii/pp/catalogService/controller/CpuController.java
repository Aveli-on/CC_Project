package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.CpuRequest;
import by.Savelii.pp.catalogService.dto.CpuResponse;
import by.Savelii.pp.catalogService.service.CpuService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping( "/api/cpus")
public class CpuController {
    private CpuService cpuService;
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());
    public CpuController(CpuService cpuService)
    {
        this.cpuService=cpuService;
    }

    @PostMapping
    public ResponseEntity<CpuResponse> create(@Valid @RequestBody CpuRequest cpuRequest){
        LOGGER.info("Request for create cpu, id: {} - {}",cpuRequest.getBrand(),cpuRequest.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(cpuService.create(cpuRequest));
    }
    @GetMapping("{id}")
    public ResponseEntity<CpuResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search cpu, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(cpuService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<CpuResponse>> getAll(){
        LOGGER.info("Request for search all objects");
        return ResponseEntity.status(HttpStatus.OK).body(cpuService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete cpu, id: {}",id);
        cpuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<CpuResponse> updateById(@PathVariable Long id ,@Valid @RequestBody CpuRequest cpuRequest){
        LOGGER.info("Request for update cpu, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(cpuService.updateById(id,cpuRequest));
    }
}
