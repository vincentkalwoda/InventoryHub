package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.AddressType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTypeConverterTest {

    private final AddressTypeConverter addressTypeConverter = new AddressTypeConverter();

    @Test
    void when_convert_a_valid_address_type_to_db_value_returns_content() {
        // arrange / given
        Character value = 'B';
        AddressType addressType = AddressType.BILLING;

        // act / when
        Character convertedValue = addressTypeConverter.convertToDatabaseColumn(addressType);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_null_address_type_to_db_value_returns_null() {
        // expect
        assertNull(addressTypeConverter.convertToDatabaseColumn(null));
    }

    @Test
    void when_convert_a_valid_address_type_value_to_an_address_type_instance() {
        // arrange / given
        Character value = 'B';

        // act / when
        var addressType = addressTypeConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(AddressType.BILLING, addressType);
    }

    @Test
    void when_convert_a_null_address_type_value_to_an_address_type_returns_null() {
        // expect
        assertNull(addressTypeConverter.convertToEntityAttribute(null));
    }
}