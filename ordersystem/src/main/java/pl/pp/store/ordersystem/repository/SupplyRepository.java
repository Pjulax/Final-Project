package pl.pp.store.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.ordersystem.model.Supply;

import java.util.List;
import java.util.Optional;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
    Optional<Supply> findByCode(String code);
    List<Supply> findAllByTargetStoreCode(String storeCode);
}
