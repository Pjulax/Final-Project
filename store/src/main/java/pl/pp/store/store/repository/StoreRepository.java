package pl.pp.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.store.model.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByCode(String code);
    Optional<Store> findByCodeAndStoreKeeper_LoginAndStoreKeeper_Password(String code, String login, String password);
}
