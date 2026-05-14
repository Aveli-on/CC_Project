package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Psu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsuRepository extends JpaRepository<Psu,Long> {
    Optional<Psu> findByBrandAndModel(String brand, String model);
}
