package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.PsuRequest;
import by.Savelii.pp.catalogService.dto.PsuResponse;
import by.Savelii.pp.catalogService.service.PsuService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/psu")
public class PsuController {
    private final PsuService psuService ;
    private final Logger LOGGER= LoggerFactory.getLogger(PsuController.class);

    public PsuController(PsuService psuService) {
        this.psuService = psuService;
    }

    @PostMapping
    public ResponseEntity<PsuResponse> create(@Valid @RequestBody PsuRequest request){
        LOGGER.info("Request for create psu : {} - {}",request.getBrand(),request.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(psuService.create(request));
    }
    @GetMapping("{id}")
    public ResponseEntity<PsuResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search psu, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(psuService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<PsuResponse>> getAll(){
        LOGGER.info("Request for search all psu");
        return ResponseEntity.status(HttpStatus.OK).body(psuService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete psu, id: {}",id);
        psuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<PsuResponse> updateById(@PathVariable Long id ,@Valid @RequestBody  PsuRequest request){
        LOGGER.info("Request for update psu, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(psuService.updateById(id,request));
    }
}

