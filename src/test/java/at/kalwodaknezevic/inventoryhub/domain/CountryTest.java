package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryTest {

    @Test
    void when_instantiated_with_null_name_throws_appropriate_CountryException() {
        Country.CountryException ex = assertThrows(Country.CountryException.class,
                () -> new Country(null, "US", "USA", 123));
        assertThat(ex.getMessage()).isEqualTo("Name must not be null or empty");
    }

    @Test
    void when_instantiated_with_invalid_iso2Code_throws_appropriate_CountryException() {
        assertThatThrownBy(() -> new Country("United States", "U", "USA", 123))
                .isInstanceOf(Country.CountryException.class)
                .hasMessage("ISO2 code must be exactly 2 letters");
    }

    @Test
    void when_instantiated_with_invalid_iso3Code_throws_appropriate_CountryException() {
        assertThatThrownBy(() -> new Country("United States", "US", "US", 123))
                .isInstanceOf(Country.CountryException.class)
                .hasMessage("ISO3 code must be exactly 3 letters");
    }

    @Test
    void when_instantiated_with_invalid_areaCode_throws_appropriate_CountryException() {
        assertThatThrownBy(() -> new Country("United States", "US", "USA", 1000))
                .isInstanceOf(Country.CountryException.class)
                .hasMessage("Area code must be a valid 1-3 digit number");
    }

    @Test
    void when_instantiated_with_null_areaCode_does_not_throw_exception() {
        assertDoesNotThrow(() -> new Country("United States", "US", "USA", null));
    }

    @Test
    void when_instantiated_with_valid_values_does_not_throw_exception() {
        assertDoesNotThrow(() -> new Country("United States", "US", "USA", 123));
    }

    @Test
    void when_instantiated_with_invalid_values_combination_throws_appropriate_CountryException() {
        assertThatThrownBy(() -> new Country("", "US", "USA", -1))
                .isInstanceOf(Country.CountryException.class)
                .hasMessage("Name must not be null or empty");
    }
}
