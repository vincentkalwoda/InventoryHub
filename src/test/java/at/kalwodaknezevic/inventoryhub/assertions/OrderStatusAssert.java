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

    public OrderStatusAssert isValidOrderStatus() {
        isNotNull();
        if (actual == null) {
            failWithMessage("Expected order status to be not null but was <%s>", actual);
        }
        return this;
    }
}