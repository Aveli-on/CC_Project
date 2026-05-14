package by.Savelii.pp.catalogService.controller;

import by.Savelii.pp.catalogService.dto.BodyRequest;
import by.Savelii.pp.catalogService.dto.BodyResponse;
import by.Savelii.pp.catalogService.service.BodyService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/body")
public class BodyController {
    private final BodyService bodyService ;
    private final Logger LOGGER= LoggerFactory.getLogger(BodyController.class);

    public BodyController(BodyService bodyService) {
        this.bodyService = bodyService;
    }

    @PostMapping
    public ResponseEntity<BodyResponse> create(@Valid @RequestBody BodyRequest request){
        LOGGER.info("Request for create body : {} - {}",request.getBrand(),request.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(bodyService.create(request));
    }
    @GetMapping("{id}")
    public ResponseEntity<BodyResponse> getById(@PathVariable Long id){
        LOGGER.info("Request for search body, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(bodyService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<BodyResponse>> getAll(){
        LOGGER.info("Request for search all body");
        return ResponseEntity.status(HttpStatus.OK).body(bodyService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        LOGGER.info("Request for delete body, id: {}",id);
        bodyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<BodyResponse> updateById(@PathVariable Long id ,@Valid @RequestBody BodyRequest request){
        LOGGER.info("Request for update body, id: {}",id);
        return ResponseEntity.status(HttpStatus.OK).body(bodyService.updateById(id,request));
    }
}

