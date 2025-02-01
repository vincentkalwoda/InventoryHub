package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.OrderStatusAssert.assertThat;

class OrderStatusTest {

    @Test
    void testOrderStatusAssertions() {
        OrderStatus orderStatus = OrderStatus.PENDING;

        assertThat(orderStatus)
                 .isValidOrderStatus();
    }
}
