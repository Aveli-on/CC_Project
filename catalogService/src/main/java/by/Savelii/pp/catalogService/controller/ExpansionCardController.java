package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.ExpansionRequest;
import by.Savelii.pp.catalogService.dto.ExpansionResponse;
import by.Savelii.pp.catalogService.dto.MotherboardRequest;
import by.Savelii.pp.catalogService.dto.MotherboardResponse;
import by.Savelii.pp.catalogService.service.ExpansionService;
import by.Savelii.pp.catalogService.service.MotherboardService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expansion")
public class ExpansionCardController {
    private final ExpansionService expansionService;
    private final Logger LOGGER= LoggerFactory.getLogger(ExpansionCardController.class);

    public ExpansionCardController(ExpansionService expansionService) {
        this.expansionService = expansionService;
    }

    @PostMapping
    public ResponseEntity<ExpansionResponse> create(@Valid @RequestBody ExpansionRequest request){
        LOGGER.info("Request for create expansion : {} - {}",request.getBrand(),request.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(expansionService.create(request));
    }
    @GetMapping("{id}")
    public ResponseEntity<ExpansionResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search expansion, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(expansionService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ExpansionResponse>> getAll(){
        LOGGER.info("Request for search all expansion");
        return ResponseEntity.status(HttpStatus.OK).body(expansionService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete expansion, id: {}",id);
        expansionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<ExpansionResponse> updateById(@PathVariable Long id ,@Valid @RequestBody ExpansionRequest request ){
        LOGGER.info("Request for update expansion, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(expansionService.updateById(id,request));
    }
}

