package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.PhoneType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTypeConverterTest {

    private final PhoneTypeConverter phoneTypeConverter = new PhoneTypeConverter();

    @Test
    void when_convert_a_valid_phone_type_home_to_db_value_returns_content() {
        // arrange / given
        Character value = 'H';
        PhoneType phoneType = PhoneType.HOME;

        // act / when
        Character convertedValue = phoneTypeConverter.convertToDatabaseColumn(phoneType);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_phone_type_mobile_to_db_value_returns_content() {
        // arrange / given
        Character value = 'M';
        PhoneType phoneType = PhoneType.MOBILE;

        // act / when
        Character convertedValue = phoneTypeConverter.convertToDatabaseColumn(phoneType);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_phone_type_work_to_db_value_returns_content() {
        // arrange / given
        Character value = 'W';
        PhoneType phoneType = PhoneType.WORK;

        // act / when
        Character convertedValue = phoneTypeConverter.convertToDatabaseColumn(phoneType);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_phone_type_fax_to_db_value_returns_content() {
        // arrange / given
        Character value = 'F';
        PhoneType phoneType = PhoneType.FAX;

        // act / when
        Character convertedValue = phoneTypeConverter.convertToDatabaseColumn(phoneType);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_phone_type_other_to_db_value_returns_content() {
        // arrange / given
        Character value = 'O';
        PhoneType phoneType = PhoneType.OTHER;

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
    void when_convert_a_valid_phone_type_home_value_to_a_phone_type_instance() {
        // arrange / given
        Character value = 'H';

        // act / when
        var phoneType = phoneTypeConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(PhoneType.HOME, phoneType);
    }

    @Test
    void when_convert_a_valid_phone_type_mobile_value_to_a_phone_type_instance() {
        // arrange / given
        Character value = 'M';

        // act / when
        var phoneType = phoneTypeConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(PhoneType.MOBILE, phoneType);
    }

    @Test
    void when_convert_a_valid_phone_type_work_value_to_a_phone_type_instance() {
        // arrange / given
        Character value = 'W';

        // act / when
        var phoneType = phoneTypeConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(PhoneType.WORK, phoneType);
    }

    @Test
    void when_convert_a_valid_phone_type_fax_value_to_a_phone_type_instance() {
        // arrange / given
        Character value = 'F';

        // act / when
        var phoneType = phoneTypeConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(PhoneType.FAX, phoneType);
    }

    @Test
    void when_convert_a_valid_phone_type_other_value_to_a_phone_type_instance() {
        // arrange / given
        Character value = 'O';

        // act / when
        var phoneType = phoneTypeConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(PhoneType.OTHER, phoneType);
    }

    @Test
    void when_convert_a_null_phone_type_value_to_a_phone_type_returns_null() {
        // expect
        assertNull(phoneTypeConverter.convertToEntityAttribute(null));
    }

    @Test
    void when_convert_an_invalid_phone_type_value_to_a_phone_type_throws_exception() {
        // expect
        assertThrows(IllegalArgumentException.class, () -> phoneTypeConverter.convertToEntityAttribute('X'));
    }
}