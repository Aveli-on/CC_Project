package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpansionRepository extends JpaRepository<Expansion,Long> {
    Optional<Expansion> findByBrandAndModel(String brand, String model);
}
