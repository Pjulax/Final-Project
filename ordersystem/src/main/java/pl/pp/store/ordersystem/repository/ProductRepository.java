package pl.pp.store.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.ordersystem.model.Product;

public interface ArticleRepository extends JpaRepository<Product, Long> {
}
