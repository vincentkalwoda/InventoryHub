package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CountryConverterTest {

    private final CountryConverter converter = new CountryConverter();

    @Test
    void when_convertToDatabaseColumn_with_valid_country_returns_correct_string() {
        Country country = new Country("United States", "US", "USA", 123);
        String dbString = converter.convertToDatabaseColumn(country);
        assertThat(dbString).isEqualTo("UnitedStatesUSUSA123");
    }

    @Test
    void when_convertToDatabaseColumn_with_null_country_returns_null() {
        String dbString = converter.convertToDatabaseColumn(null);
        assertThat(dbString).isNull();
    }

    @Test
    void when_convertToEntityAttribute_with_valid_string_returns_correct_country() {
        String dbString = "UnitedStatesUSUSA123";
        Country country = converter.convertToEntityAttribute(dbString);
        assertThat(country).isNotNull();
        assertThat(country.name()).isEqualTo("UnitedStates");
        assertThat(country.iso2Code()).isEqualTo("US");
        assertThat(country.iso3Code()).isEqualTo("USA");
        assertThat(country.areaCode()).isEqualTo(123);
    }

    @Test
    void when_convertToEntityAttribute_with_null_string_returns_null() {
        Country country = converter.convertToEntityAttribute(null);
        assertThat(country).isNull();
    }

    @Test
    void when_convertToEntityAttribute_with_invalid_string_throws_CountryException() {
        String dbString = "InvalidString";
        assertThatThrownBy(() -> converter.convertToEntityAttribute(dbString))
                .isInstanceOf(Country.CountryException.class)
                .hasMessage("Input string does not contain valid ISO codes or area code");
    }
}