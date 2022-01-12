package pl.pp.store.reporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.reporting.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
