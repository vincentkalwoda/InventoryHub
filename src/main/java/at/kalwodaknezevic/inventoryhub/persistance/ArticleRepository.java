package at.kalwodaknezevic.inventoryhub.persistance;
import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Article.ArticleId> {
    Optional<Article> findByArticleId(Article.ArticleId articleId);
    Optional<Article> findByName(Name title);
}