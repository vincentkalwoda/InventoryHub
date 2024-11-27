package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.PhoneType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTypeConverterTest {

    private final PhoneTypeConverter phoneTypeConverter = new PhoneTypeConverter();

    @Test
    void when_convert_a_valid_phone_type_to_db_value_returns_content() {
        // arrange / given
        Character value = 'H';
        PhoneType phoneType = PhoneType.HOME;

        // act / when
        Character convertedValue = phoneTypeConverter.convertToDatabaseColumn(phoneType);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_null_phone_type_to_db_value_returns_null() {
        // expect
        assertNull(phoneTypeConverter.convertToDatabaseColumn(null));
    }

    @Test
    void when_convert_a_valid_phone_type_value_to_a_phone_type_instance() {
        // arrange / given
        Character value = 'H';

        // act / when
        var phoneType = phoneTypeConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(PhoneType.HOME, phoneType);
    }

    @Test
    void when_convert_a_null_phone_type_value_to_a_phone_type_returns_null() {
        // expect
        assertNull(phoneTypeConverter.convertToEntityAttribute(null));
    }
}