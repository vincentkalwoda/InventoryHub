package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Order;
import org.assertj.core.api.AbstractAssert;

public class OrderAssert extends AbstractAssert<OrderAssert, Order> {
    public OrderAssert(Order order) {
        super(order, OrderAssert.class);
    }

    public static OrderAssert assertThat(Order actual) {
        return new OrderAssert(actual);
    }

    public OrderAssert hasValidOrderStatus() {
        isNotNull();
        if (actual.getOrderStatus() == null) {
            failWithMessage("Expected order's order status to be not null but was <%s>", actual.getOrderStatus());
        }
        return this;
    }

    public OrderAssert hasValidOrderDate() {
        isNotNull();
        if (actual.getOrderDate() == null) {
            failWithMessage("Expected order's order date to be not null but was <%s>", actual.getOrderDate());
        }
        return this;
    }

    public OrderAssert hasValidDeliveryDate() {
        isNotNull();
        if (actual.getDeliveryDate() == null) {
            failWithMessage("Expected order's delivery date to be not null but was <%s>", actual.getDeliveryDate());
        }
        return this;
    }

    public OrderAssert hasValidOrderItems() {
        isNotNull();
        if (actual.getOrderItems() == null || actual.getOrderItems().isEmpty()) {
            failWithMessage("Expected order's order items to be not null and not empty but was <%s>", actual.getOrderItems());
        }
        return this;
    }

    public OrderAssert hasValidEmployee() {
        isNotNull();
        if (actual.getEmployees() == null) {
            failWithMessage("Expected order's employee to be not null but was <%s>", actual.getEmployees());
        }
        return this;
    }

    public OrderAssert hasValidSupplier() {
        isNotNull();
        if (actual.getSupplier() == null) {
            failWithMessage("Expected order's supplier to be not null but was <%s>", actual.getSupplier());
        }
        return this;
    }
}