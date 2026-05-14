package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Fan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FanRepository extends JpaRepository<Fan,Long> {
    Optional<Fan> findByBrandAndModel(String brand, String model);
}