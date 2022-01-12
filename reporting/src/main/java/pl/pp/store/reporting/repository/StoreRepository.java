package pl.pp.store.reporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.reporting.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
