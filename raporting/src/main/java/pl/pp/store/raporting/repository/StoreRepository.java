package pl.pp.store.raporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.raporting.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
