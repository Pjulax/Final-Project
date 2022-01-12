package pl.pp.store.reporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.reporting.model.StoredProduct;

public interface StoredProductRepository extends JpaRepository<StoredProduct, Long> {
}
