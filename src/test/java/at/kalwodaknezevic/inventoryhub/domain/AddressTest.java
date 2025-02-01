package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.AddressAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AddressTest {

    @Test
    void testAddressAssertions() {
        Address address = FixturesFactory.spengergasse20(FixturesFactory.austria());

        assertThat(address)
                .hasValidStreet()
                .hasValidCity()
                .hasValidZipCode()
                .hasValidCountry()
                .hasValidAddressType();
    }

    @Test
    void shouldThrowExceptionWhenStreetIsNull() {
        assertThatThrownBy(() -> new Address(null, "City", "12345", FixturesFactory.austria(), AddressType.BILLING))
                .isInstanceOf(Address.AddressException.class)
                .hasMessage("Street must not be null!");
    }

    @Test
    void shouldThrowExceptionWhenCityIsNull() {
        assertThatThrownBy(() -> new Address("Street", null, "12345", FixturesFactory.austria(), AddressType.BILLING))
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

    @Test
    void when_instantiated_with_valid_value_does_not_throw_exception() {
        assertDoesNotThrow(() -> FixturesFactory.spengergasse20(FixturesFactory.austria()));
    }
}