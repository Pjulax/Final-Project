package pl.pp.store.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.ordersystem.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
