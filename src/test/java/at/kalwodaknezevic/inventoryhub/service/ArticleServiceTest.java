package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.persistance.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    private @Mock ArticleRepository articleRepository;

    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        assumeThat(articleRepository).isNotNull();
        articleService = new ArticleService(articleRepository);
    }

    @Test
    void can_create_article() {
        var article = FixturesFactory.article();
        when(articleRepository.save(article)).thenReturn(article);

        var createdArticle = articleService.createArticle(article.getName(), article.getDescription(), article.getCategory(), article.getPrice(), article.getQuantity());
        assertThat(createdArticle).isEqualTo(article);
    }
}