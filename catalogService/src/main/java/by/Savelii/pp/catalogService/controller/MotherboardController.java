package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.CpuRequest;
import by.Savelii.pp.catalogService.dto.CpuResponse;
import by.Savelii.pp.catalogService.dto.MotherboardRequest;
import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.service.MotherboardService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/motherboard")
public class MotherboardController {
    private final MotherboardService motherboardService;
    private final Logger LOGGER= LoggerFactory.getLogger(MotherboardController.class);

    public MotherboardController(MotherboardService motherboardService) {
        this.motherboardService = motherboardService;
    }
    @PostMapping
    public ResponseEntity<MotherboardResponse> create(@Valid @RequestBody MotherboardRequest motherboardRequest){
        LOGGER.info("Request for create motherboard : {} - {}",motherboardRequest.getBrand(),motherboardRequest.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(motherboardService.create(motherboardRequest));
    }
    @GetMapping("{id}")
    public ResponseEntity<MotherboardResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search motherboard, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(motherboardService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<MotherboardResponse>> getAll(){
        LOGGER.info("Request for search all motherboard");
        return ResponseEntity.status(HttpStatus.OK).body(motherboardService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete motherboard, id: {}",id);
        motherboardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<MotherboardResponse> updateById(@PathVariable Long id ,@Valid @RequestBody MotherboardRequest motherboardRequest){
        LOGGER.info("Запрос на обновление объекта с id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(motherboardService.updateById(id,motherboardRequest));
    }
}
