package pl.pp.store.raporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.raporting.model.StoredProduct;

public interface StoredProductRepository extends JpaRepository<StoredProduct, Long> {
}
