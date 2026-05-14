package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.FanRequest;
import by.Savelii.pp.catalogService.dto.FanResponse;
import by.Savelii.pp.catalogService.dto.MotherboardRequest;
import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.service.FanService;
import by.Savelii.pp.catalogService.service.MotherboardService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fan")
public class FanController {
    private final FanService fanService ;
    private final Logger LOGGER= LoggerFactory.getLogger(FanController.class);

    public FanController(FanService fanService) {
        this.fanService = fanService;
    }

    @PostMapping
    public ResponseEntity<FanResponse> create(@Valid @RequestBody FanRequest request ){
        LOGGER.info("Request for create fan : {} - {}",request.getBrand(),request.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(fanService.create(request));
    }
    @GetMapping("{id}")
    public ResponseEntity<FanResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search fan, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(fanService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<FanResponse>> getAll(){
        LOGGER.info("Request for search all fan");
        return ResponseEntity.status(HttpStatus.OK).body(fanService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete fan, id: {}",id);
        fanService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<FanResponse> updateById(@PathVariable Long id ,@Valid @RequestBody FanRequest request ){
        LOGGER.info("Request for update fan, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(fanService.updateById(id,request));
    }
}

