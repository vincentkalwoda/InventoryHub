package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountryConverterTest {

    private final CountryConverter converter = new CountryConverter();

    @Test
    void when_convertToEntityAttribute_with_valid_string_with_areaCode_returns_correct_country() {
        String dbString = "United StatesUSUSA123"; // Example input string
        Country country = converter.convertToEntityAttribute(dbString);

        assertThat(country).isNotNull();
        assertThat(country.getName()).isEqualTo("United States");
        assertThat(country.getIso2Code()).isEqualTo("US");
        assertThat(country.getIso3Code()).isEqualTo("USA");
        assertThat(country.getAreaCode()).isEqualTo(123);
    }

    @Test
    void when_convertToEntityAttribute_with_valid_string_without_areaCode_returns_correct_country() {
        String dbString = "United StatesUSUSA";
        Country country = converter.convertToEntityAttribute(dbString);
        assertThat(country).isNotNull();
        assertThat(country.getName()).isEqualTo("United States");
        assertThat(country.getIso2Code()).isEqualTo("US");
        assertThat(country.getIso3Code()).isEqualTo("USA");
        assertThat(country.getAreaCode()).isNull();
    }

    @Test
    void when_convertToEntityAttribute_with_null_string_returns_null() {
        String dbString = null;
        Country country = converter.convertToEntityAttribute(dbString);
        assertThat(country).isNull();
    }

    @Test
    void when_convertToEntityAttribute_with_empty_string_returns_null() {
        String dbString = "";
        Country country = converter.convertToEntityAttribute(dbString);
        assertThat(country).isNull();
    }
}