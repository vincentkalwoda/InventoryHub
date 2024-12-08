package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;
import at.kalwodaknezevic.inventoryhub.domain.PhoneType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PhoneNumberConverterTest {

    private final PhoneNumberConverter phoneNumberConverter = new PhoneNumberConverter();

    @Test
    void when_convert_a_valid_phone_number_to_db_data_returns_content() {
        // arrange
        PhoneNumber phoneNumber = new PhoneNumber(1, 123, "4567890", 1234, PhoneType.MOBILE);
        String expectedValue = "1-123-4567890-1234-MOBILE";

        // act
        var convertedValue = phoneNumberConverter.convertToDatabaseColumn(phoneNumber);

        // assert
        assertThat(convertedValue).isEqualTo(expectedValue);
    }

    @Test
    void when_convert_a_null_phone_number_to_db_data_returns_null() {
        // expect
        assertThat(phoneNumberConverter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void when_convert_a_valid_phone_number_value_to_a_phone_number_instance() {
        // arrange
        String dbData = "1-123-4567890-1234-MOBILE";

        // act
        var convertedValue = phoneNumberConverter.convertToEntityAttribute(dbData);

        // assert
        assertThat(convertedValue.countryCode()).isEqualTo(1);
        assertThat(convertedValue.areaCode()).isEqualTo(123);
        assertThat(convertedValue.serialCode()).isEqualTo("4567890");
        assertThat(convertedValue.extension()).isEqualTo(1234);
        assertThat(convertedValue.phoneType()).isEqualTo(PhoneType.MOBILE);
    }

    @Test
    void when_convert_a_null_phone_number_value_to_a_phone_number_returns_null() {
        // expect
        assertThat(phoneNumberConverter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    void when_convert_an_invalid_phone_number_value_to_a_phone_number_throws_exception() {
        // expect
        assertThatThrownBy(() -> phoneNumberConverter.convertToEntityAttribute("1-123-4567890-1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}