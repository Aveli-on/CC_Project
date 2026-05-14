package by.Savelii.pp.compatibilityService.service;

import by.Savelii.pp.compatibilityService.dto.CompatibilityRequest;
import by.Savelii.pp.compatibilityService.dto.CompatibilityResponse;
import by.Savelii.pp.compatibilityService.repository.ComponentRepository;
import by.Savelii.pp.compatibilityService.repository.entity.Component;
import by.Savelii.pp.core.ComponentType;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompatibilityService {
    private ComponentRepository componentRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    public CompatibilityService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public CompatibilityResponse getProblems(CompatibilityRequest request)
    {
        CompatibilityResponse response=new CompatibilityResponse();
        response.setErrors(new ArrayList<>());
        Optional<Component> cpu=request.getCpuId()!= null?componentRepository.findByProductIdAndComponentType(request.getCpuId(), ComponentType.CPU): Optional.empty();
        Optional<Component>  gpu=request.getGpuId()!= null?componentRepository.findByProductIdAndComponentType(request.getGpuId(),ComponentType.GPU): Optional.empty();
        Optional<Component>  ram=request.getRamId()!= null?componentRepository.findByProductIdAndComponentType(request.getRamId(),ComponentType.RAM): Optional.empty();
        Optional<Component>  motherboard=request.getMotherboardId()!= null?componentRepository.findByProductIdAndComponentType(request.getMotherboardId(),ComponentType.MOTHERBOARD): Optional.empty();
        Optional<Component>  psu=request.getPsuId()!= null?componentRepository.findByProductIdAndComponentType(request.getPsuId(),ComponentType.PSU): Optional.empty();
        Optional<Component>  m2=request.getM2Id()!= null?componentRepository.findByProductIdAndComponentType(request.getM2Id(),ComponentType.M2): Optional.empty();
        Optional<Component>  body=request.getBodyId()!= null?componentRepository.findByProductIdAndComponentType(request.getBodyId(),ComponentType.BODY): Optional.empty();
        Optional<Component>  cooler=request.getCoolerId()!= null?componentRepository.findByProductIdAndComponentType(request.getCoolerId(),ComponentType.COOLER): Optional.empty();
        Optional<Component>  expansionCard=request.getExpansionCardId()!= null?componentRepository.findByProductIdAndComponentType(request.getExpansionCardId(),ComponentType.EXPANSION_CARD): Optional.empty();
        Optional<Component>  fan=request.getFanId()!= null?componentRepository.findByProductIdAndComponentType(request.getFanId(),ComponentType.FAN): Optional.empty();
        if (cpu.isPresent()&& motherboard.isPresent()&& !Objects.equals(cpu.get().getSpecifications().get("socket"), motherboard.get().getSpecifications().get("socket"))){
            response.getErrors().add("Сокет процессора (" + cpu.get().getSpecifications().get("socket") + ") не подходит к сокету материнской платы (" + motherboard.get().getSpecifications().get("socket") + ")");
        }
        return response;
    }

}
