package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.CategoryAssert.assertThat;

class CategoryTest {
    @Test
    void testCategoryAssertions() {
        Category category = Category.OTHER;

        assertThat(category)
                 .isValidCategory();
    }
}
