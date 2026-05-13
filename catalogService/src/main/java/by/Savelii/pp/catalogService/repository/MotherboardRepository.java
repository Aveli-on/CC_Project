package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotherboardRepository extends JpaRepository<Motherboard,Long> {
    Optional<Motherboard> findByBrandAndModel(String brand,String model);
}
