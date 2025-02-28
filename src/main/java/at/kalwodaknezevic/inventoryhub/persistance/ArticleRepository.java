package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Article.ArticleId> {
    Optional<Article> findByArticleId(Article.ArticleId articleId);

    List<Article> findByName(String title);

    Optional<Article> findByApiKey(ApiKey apiKey);
}