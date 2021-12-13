package pl.pp.store.raporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pp.store.raporting.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
