package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.commands.ArticleCommands.CreateArticleCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.persistance.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    private @Mock ArticleRepository articleRepository;

    private ArticleService articleService;
    private Article article;
    private CreateArticleCommand createArticleCommand;

    @BeforeEach
    void setUp() {
        assumeThat(articleRepository).isNotNull();
        articleService = new ArticleService(articleRepository);
        article = FixturesFactory.article();
        createArticleCommand = FixturesFactory.createArticleCommand(article);
    }

    @Test
    void can_create_article() {
        var article = FixturesFactory.article();
        when(articleRepository.findByApiKey(any(ApiKey.class))).thenReturn(Optional.empty());
        when(articleRepository.save(any(Article.class))).thenReturn(article);

        var createdArticle = articleService.createArticle(createArticleCommand);
        assertThat(createdArticle).isEqualTo(article);
    }

    @Test
    void can_get_all_articles() {
        var article = FixturesFactory.article();
        when(articleRepository.findAll()).thenReturn(List.of(article));

        var articles = articleService.getAll();
        assertThat(articles).containsExactly(article);
    }
}