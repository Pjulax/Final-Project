package pl.pp.store.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.ordersystem.model.StoredProduct;

import java.util.List;
import java.util.Optional;

public interface StoredProductRepository extends JpaRepository<StoredProduct, Long> {
    List<StoredProduct> findAllByStoreCode(String code);
    List<StoredProduct> findAllByProduct_Code(String productCode);
    Optional<StoredProduct> findByStoreCodeAndProduct_Code(String storeCode, String productCode);
}
