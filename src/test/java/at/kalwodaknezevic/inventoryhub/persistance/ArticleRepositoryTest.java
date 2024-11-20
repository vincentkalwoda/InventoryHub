package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ArticleRepositoryTest {
    private @Autowired ArticleRepository articleRepository;
    private Name name;
    private Article article;

    @BeforeEach
    void setup() {
        name = new Name("Article 1");
        article = Article.builder()
                .name(name)
                .description("Description")
                .build();

    }

    @Test
    void can_save() {
        // expect
        assertThat(articleRepository.saveAndFlush(article).getArticleId()).isNotNull();
    }

    @Test
    void can_find_by_title() {
        // arrange / given
        articleRepository.saveAndFlush(article);

        // act / when
        var foundArticle = articleRepository.findByName(name);

        // assert / then
        assertThat(foundArticle).isNotEmpty();
        assertThat(foundArticle.get().getName()).isEqualTo(name);
    }
}