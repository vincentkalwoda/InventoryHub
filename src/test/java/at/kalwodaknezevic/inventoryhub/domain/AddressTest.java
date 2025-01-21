package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AddressTest {

    @Test
    void shouldThrowExceptionWhenStreetIsNull() {
        assertThatThrownBy(() -> new Address(null, "City", "12345", FixturesFactory.austria(), AddressType.BILLING))
                .isInstanceOf(Address.AddressException.class)
                .hasMessage("Street must not be null!");
    }

    @Test
    void shouldThrowExceptionWhenCityIsNull() {
        assertThatThrownBy(() -> new Address("Street", null, "12345",FixturesFactory.austria(), AddressType.BILLING))
                .isInstanceOf(Address.AddressException.class)
                .hasMessage("City must not be null!");
    }

    @Test
    void shouldThrowExceptionWhenZipCodeIsNull() {
        assertThatThrownBy(() -> new Address("Street", "City", null, FixturesFactory.austria(), AddressType.BILLING))
                .isInstanceOf(Address.AddressException.class)
                .hasMessage("Zip code must not be null!");
    }

    @Test
    void shouldThrowExceptionWhenCountryIsNull() {
        assertThatThrownBy(() -> new Address("Street", "City", "12345", null, AddressType.BILLING))
                .isInstanceOf(Address.AddressException.class)
                .hasMessage("Country must not be null!");
    }

    @Test
    void shouldThrowExceptionWhenAddressTypeIsNull() {
        assertThatThrownBy(() -> new Address("Street", "City", "12345", FixturesFactory.austria(), null))
                .isInstanceOf(Address.AddressException.class)
                .hasMessage("Address type must not be null!");
    }
}