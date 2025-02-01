package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;

class ArticleTest {

    @Test
    void testArticleAssertions() {
        Article article = FixturesFactory.article();

        assertThat(article)
                .hasValidName()
                .hasValidPrice()
                .hasValidCategory()
                .hasValidQuantity()
                .hasValidDescription();
    }
}