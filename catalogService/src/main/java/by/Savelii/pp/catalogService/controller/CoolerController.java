package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.CoolerRequest;
import by.Savelii.pp.catalogService.dto.CoolerResponse;
import by.Savelii.pp.catalogService.service.CoolerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cooler")
public class CoolerController {
    private final CoolerService coolerService ;
    private final Logger LOGGER= LoggerFactory.getLogger(CoolerController.class);

    public CoolerController(CoolerService coolerService) {
        this.coolerService = coolerService;
    }

    @PostMapping
    public ResponseEntity<CoolerResponse> create(@Valid @RequestBody CoolerRequest request){
        LOGGER.info("Request for create cooler : {} - {}",request.getBrand(),request.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(coolerService.create(request));
    }
    @GetMapping("{id}")
    public ResponseEntity<CoolerResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search cooler, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(coolerService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<CoolerResponse>> getAll(){
        LOGGER.info("Request for search all cooler");
        return ResponseEntity.status(HttpStatus.OK).body(coolerService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete cooler, id: {}",id);
        coolerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<CoolerResponse> updateById(@PathVariable Long id ,@Valid @RequestBody CoolerRequest request){
        LOGGER.info("Request for update cooler, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(coolerService.updateById(id,request));
    }
}

