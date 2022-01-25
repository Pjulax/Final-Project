package pl.pp.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.store.model.StoreKeeper;

import java.util.Optional;

public interface StoreKeeperRepository extends JpaRepository<StoreKeeper, Long> {
    Optional<StoreKeeper> findByLogin(String login);
}
