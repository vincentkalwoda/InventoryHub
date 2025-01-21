package at.kalwodaknezevic.inventoryhub.persistance;
import at.kalwodaknezevic.inventoryhub.TestcontainersConfiguration;
import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Category;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class ArticleRepositoryTest {
    private @Autowired ArticleRepository articleRepository;
    @BeforeEach
    void setup() {
        assumeThat(articleRepository).isNotNull();
    }
    @Test
    void can_save() {

        Article article = Article.builder()
                .name(new Name("Test"))
                .description("Test")
                .category(Category.CLOTHING)
                .price(1.0f)
                .quantity(1)
                .build();
        // expect
        assertThat(articleRepository.saveAndFlush(article).getArticleId()).isNotNull();
    }
}