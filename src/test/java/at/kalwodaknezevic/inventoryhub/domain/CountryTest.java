package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;

class CountryTest {

    @Test
    void testCountryAssertions() {
        Country country = FixturesFactory.austria();

        assertThat(country)
                .hasValidName()
                .hasValidIso2Code()
                .hasValidIso3Code()
                .hasValidAreaCode();
    }
}
