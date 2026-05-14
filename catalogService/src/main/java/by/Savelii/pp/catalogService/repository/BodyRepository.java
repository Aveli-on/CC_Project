package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Body;
import by.Savelii.pp.catalogService.repository.entity.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BodyRepository extends JpaRepository<Body,Long> {
    Optional<Body> findByBrandAndModel(String brand, String model);
}