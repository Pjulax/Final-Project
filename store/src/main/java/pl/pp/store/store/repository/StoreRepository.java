package pl.pp.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.store.model.Store;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {
}
