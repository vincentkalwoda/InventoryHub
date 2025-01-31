package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.OrderStatus;
import org.assertj.core.api.AbstractAssert;

public class OrderStatusAssert extends AbstractAssert<OrderStatusAssert, OrderStatus> {
    public OrderStatusAssert(OrderStatus orderStatus) {
        super(orderStatus, OrderStatusAssert.class);
    }

    public static OrderStatusAssert assertThat(OrderStatus actual) {
        return new OrderStatusAssert(actual);
    }

    public OrderStatusAssert hasValidOrderStatus() {
        isNotNull();
        if (actual == null) {
            failWithMessage("Expected order status to be not null but was <%s>", actual);
        }
        return this;
    }

    public OrderStatusAssert isPending() {
        isNotNull();
        if (!actual.equals(OrderStatus.PENDING)) {
            failWithMessage("Expected order status to be PENDING but was <%s>", actual);
        }
        return this;
    }

    public OrderStatusAssert isShipped() {
        isNotNull();
        if (!actual.equals(OrderStatus.SHIPPED)) {
            failWithMessage("Expected order status to be SHIPPED but was <%s>", actual);
        }
        return this;
    }

    public OrderStatusAssert isDelivered() {
        isNotNull();
        if (!actual.equals(OrderStatus.DELIVERED)) {
            failWithMessage("Expected order status to be DELIVERED but was <%s>", actual);
        }
        return this;
    }

    public OrderStatusAssert isCancelled() {
        isNotNull();
        if (!actual.equals(OrderStatus.CANCELLED)) {
            failWithMessage("Expected order status to be CANCELLED but was <%s>", actual);
        }
        return this;
    }
}