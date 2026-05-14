package by.Savelii.pp.catalogService.repository;

import by.Savelii.pp.catalogService.repository.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<Storage, Long> {
    Optional<Storage> findByBrandAndModel(String brand, String model);
}
