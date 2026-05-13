package by.Savelii.pp.compatibilityService.controller;

import by.Savelii.pp.compatibilityService.dto.CompatibilityRequest;
import by.Savelii.pp.compatibilityService.dto.CompatibilityResponse;
import by.Savelii.pp.compatibilityService.service.CompatibilityService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compatibility/check")
public class ClientController {
    private CompatibilityService compatibilityService;
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());
    public ClientController(CompatibilityService compatibilityService) {
        this.compatibilityService = compatibilityService;
    }

    @PostMapping
    public ResponseEntity<CompatibilityResponse> checkBuild(@Valid @RequestBody CompatibilityRequest request){
        return ResponseEntity.status(201).body(compatibilityService.getProblems(request));
    }
}
