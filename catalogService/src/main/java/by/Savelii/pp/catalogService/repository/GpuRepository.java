package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GpuRepository extends JpaRepository<Gpu,Long> {
    Optional<Gpu> findByBrandAndModel(String brand, String model);
}
