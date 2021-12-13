package pl.pp.store.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.ordersystem.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
