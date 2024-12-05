package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.OrderStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatusConverterTest {

    private final OrderStatusConverter orderStatusConverter = new OrderStatusConverter();

    @Test
    void when_convert_a_valid_order_status_to_db_value_returns_content() {
        // arrange / given
        Character value = 'P';
        OrderStatus orderStatus = OrderStatus.PENDING;

        // act / when
        Character convertedValue = orderStatusConverter.convertToDatabaseColumn(orderStatus);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_null_order_status_to_db_value_returns_null() {
        // expect
        assertNull(orderStatusConverter.convertToDatabaseColumn(null));
    }

    @Test
    void when_convert_a_valid_order_status_value_to_an_order_status_instance() {
        // arrange / given
        Character value = 'P';

        // act / when
        var orderStatus = orderStatusConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(OrderStatus.PENDING, orderStatus);
    }

    @Test
    void when_convert_a_null_order_status_value_to_an_order_status_returns_null() {
        // expect
        assertNull(orderStatusConverter.convertToEntityAttribute(null));
    }
}