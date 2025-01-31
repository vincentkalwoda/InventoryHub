package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.OrderItem;
import org.assertj.core.api.AbstractAssert;

public class OrderItemAssert extends AbstractAssert<OrderItemAssert, OrderItem> {
    public OrderItemAssert(OrderItem orderItem) {
        super(orderItem, OrderItemAssert.class);
    }

    public static OrderItemAssert assertThat(OrderItem actual) {
        return new OrderItemAssert(actual);
    }

    public OrderItemAssert hasValidArticle() {
        isNotNull();
        if (actual.getArticle() == null) {
            failWithMessage("Expected order item's article to be not null but was <%s>", actual.getArticle());
        }
        return this;
    }

    public OrderItemAssert hasValidQuantity() {
        isNotNull();
        if (actual.getQuantity() < 1) {
            failWithMessage("Expected order item's quantity to be at least 1 but was <%s>", actual.getQuantity());
        }
        return this;
    }
}