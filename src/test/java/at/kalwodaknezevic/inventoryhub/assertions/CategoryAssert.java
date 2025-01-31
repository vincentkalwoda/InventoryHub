package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Category;
import org.assertj.core.api.AbstractAssert;

public class CategoryAssert extends AbstractAssert<CategoryAssert, Category> {
    public CategoryAssert(Category category) {
        super(category, CategoryAssert.class);
    }

    public static CategoryAssert assertThat(Category actual) {
        return new CategoryAssert(actual);
    }

    public CategoryAssert isValidCategory() {
        isNotNull();
        if (actual == null) {
            failWithMessage("Expected category to be not null but was null");
        }
        return this;
    }
}