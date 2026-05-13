package by.Savelii.pp.compatibilityService.repository;

import by.Savelii.pp.compatibilityService.repository.entity.Component;
import by.Savelii.pp.core.ComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ComponentRepository extends JpaRepository<Component, Long> {
    Optional<Component> findByProductIdAndComponentType(Long productId, ComponentType componentType);
}
