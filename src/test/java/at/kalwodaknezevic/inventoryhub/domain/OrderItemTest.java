package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;

class OrderItemTest {
    @Test
    void testOrderItemAssertions() {
        OrderItem orderItem = FixturesFactory.orderItem(FixturesFactory.article());

        assertThat(orderItem)
                .hasValidArticle()
                .hasValidQuantity();
    }
}
