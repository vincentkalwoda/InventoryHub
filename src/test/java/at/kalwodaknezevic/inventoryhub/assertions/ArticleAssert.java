package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Article;
import org.assertj.core.api.AbstractAssert;

public class ArticleAssert extends AbstractAssert<ArticleAssert, Article> {
    public ArticleAssert(Article article) {
        super(article, ArticleAssert.class);
    }

    public static ArticleAssert assertThat(Article actual) {
        return new ArticleAssert(actual);
    }

    public ArticleAssert hasValidName() {
        isNotNull();
        if (actual.getName() == null || actual.getName().toString().isEmpty()) {
            failWithMessage("Expected article's name to be not null and not empty but was <%s>", actual.getName());
        }
        return this;
    }

    public ArticleAssert hasValidPrice() {
        isNotNull();
        if (actual.getPrice() == null || actual.getPrice() <= 0) {
            failWithMessage("Expected article's price to be greater than 0 but was <%s>", actual.getPrice());
        }
        return this;
    }

    public ArticleAssert hasValidCategory() {
        isNotNull();
        if (actual.getCategory() == null) {
            failWithMessage("Expected article's category to be not null but was <%s>", actual.getCategory());
        }
        return this;
    }

    public ArticleAssert hasValidQuantity() {
        isNotNull();
        if (actual.getQuantity() == null || actual.getQuantity() < 0) {
            failWithMessage("Expected article's quantity to be not null and non-negative but was <%s>", actual.getQuantity());
        }
        return this;
    }

    public ArticleAssert hasValidDescription() {
        isNotNull();
        if (actual.getDescription() == null || actual.getDescription().isEmpty()) {
            failWithMessage("Expected article's description to be not null and not empty but was <%s>", actual.getDescription());
        }
        return this;
    }
}