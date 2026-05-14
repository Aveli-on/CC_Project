package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.MotherboardRequest;
import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.dto.RamRequest;
import by.Savelii.pp.catalogService.dto.RamResponse;
import by.Savelii.pp.catalogService.service.MotherboardService;
import by.Savelii.pp.catalogService.service.RamService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ram")
public class RamController {
    private final RamService ramService ;
    private final Logger LOGGER= LoggerFactory.getLogger(RamController.class);

    public RamController(RamService ramService) {
        this.ramService = ramService;
    }

    @PostMapping
    public ResponseEntity<RamResponse> create(@Valid @RequestBody RamRequest request){
        LOGGER.info("Request for create ram : {} - {}",request.getBrand(),request.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(ramService.create(request));
    }
    @GetMapping("{id}")
    public ResponseEntity<RamResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search ram, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(ramService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<RamResponse>> getAll(){
        LOGGER.info("Request for search all ram");
        return ResponseEntity.status(HttpStatus.OK).body(ramService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete ram, id: {}",id);
        ramService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<RamResponse> updateById(@PathVariable Long id ,@Valid @RequestBody RamRequest request){
        LOGGER.info("Request for update ram, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(ramService.updateById(id,request));
    }
}

