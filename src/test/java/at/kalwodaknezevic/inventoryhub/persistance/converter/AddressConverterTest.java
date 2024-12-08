package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Address;
import at.kalwodaknezevic.inventoryhub.domain.AddressType;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AddressConverterTest {

    private final AddressConverter addressConverter = new AddressConverter();

    @Test
    void when_convert_a_valid_address_to_db_data_returns_content() {
        // arrange
        Address address = new Address("Main St", "Springfield", "12345", new Country("Country", "C1", "C2", 1), AddressType.BILLING);
        String expectedValue = "Main St,Springfield,12345,Country,BILLING";

        // act
        var convertedValue = addressConverter.convertToDatabaseColumn(address);

        // assert
        assertThat(convertedValue).isEqualTo(expectedValue);
    }

    @Test
    void when_convert_a_null_address_to_db_data_returns_null() {
        // expect
        assertThat(addressConverter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void when_convert_a_valid_address_value_to_an_address_instance() {
        // arrange
        String dbData = "Main St,Springfield,12345,Country,BILLING";

        // act
        var convertedValue = addressConverter.convertToEntityAttribute(dbData);

        // assert
        assertThat(convertedValue.street()).isEqualTo("Main St");
        assertThat(convertedValue.city()).isEqualTo("Springfield");
        assertThat(convertedValue.zipCode()).isEqualTo("12345");
        assertThat(convertedValue.country().getName()).isEqualTo("Country");
        assertThat(convertedValue.addressType()).isEqualTo(AddressType.BILLING);
    }

    @Test
    void when_convert_a_null_address_value_to_an_address_returns_null() {
        // expect
        assertThat(addressConverter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    void when_convert_an_invalid_address_value_to_an_address_throws_exception() {
        // expect
        assertThatThrownBy(() -> addressConverter.convertToEntityAttribute("Main St,Springfield,12345,Country"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid address data: Main St,Springfield,12345,Country");
    }
}