package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Cooler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoolerRepository extends JpaRepository<Cooler,Long> {
    Optional<Cooler> findByBrandAndModel(String brand, String model);
}