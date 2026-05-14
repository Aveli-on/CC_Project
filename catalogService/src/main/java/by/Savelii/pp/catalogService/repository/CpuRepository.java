package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CpuRepository extends JpaRepository<Cpu,Long> {
    Optional<Cpu> findByBrandAndModel(String brand,String model);
}
