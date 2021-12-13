package pl.pp.store.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.ordersystem.model.StoredProduct;

public interface StoredProductRepository extends JpaRepository<StoredProduct, Long> {
}
