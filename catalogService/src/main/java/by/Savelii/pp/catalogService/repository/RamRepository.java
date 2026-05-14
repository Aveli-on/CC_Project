package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RamRepository extends JpaRepository<Ram,Long> {
    Optional<Ram> findByBrandAndModel(String brand, String model);
}
