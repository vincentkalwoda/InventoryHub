package at.kalwodaknezevic.inventoryhub.domain;


import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

class PhoneNumberTest {

    @Test
    void testPhoneNumberAssertions() {
        PhoneNumber phoneNumber = new PhoneNumber(1, 1, "1234567890", 0, PhoneType.MOBILE);

        assertThat(phoneNumber)
                .hasValidAreaCode()
                .hasValidCountryCode()
                .hasValidSerialCode()
                .hasValidExtension();
    }

    @Test
    void when_instantiated_with_null_serial_code_throws_appropriate_PhoneNumberException() {
        PhoneNumber.PhoneNumberException ex = assertThrows(PhoneNumber.PhoneNumberException.class, () -> new PhoneNumber(1, 1, null, 0, PhoneType.MOBILE));
        assertThat(ex.getMessage()).isEqualTo("Serial code must not be null or blank!");
    }

    @Test
    void when_instantiated_with_invalid_phone_type_throws_appropriate_PhoneNumberException() {
        PhoneNumber.PhoneNumberException ex = assertThrows(PhoneNumber.PhoneNumberException.class, () -> new PhoneNumber(1, 1, "1234567890", 0, null));
        assertThat(ex.getMessage()).isEqualTo("Phone type must not be null or empty!");
   }

    @Test
    void when_instantiated_with_invalid_country_code_throws_appropriate_PhoneNumberException() {
        PhoneNumber.PhoneNumberException ex = assertThrows(PhoneNumber.PhoneNumberException.class, () -> new PhoneNumber(0, 1, "1234567890", 0, PhoneType.MOBILE));
        assertThat(ex.getMessage()).isEqualTo("Country code must be between 1 and 999!");
    }

    @Test
    void when_instantiated_with_invalid_area_code_throws_appropriate_PhoneNumberException() {
        PhoneNumber.PhoneNumberException ex = assertThrows(PhoneNumber.PhoneNumberException.class, () -> new PhoneNumber(1, 0, "1234567890", 0, PhoneType.MOBILE));
        assertThat(ex.getMessage()).isEqualTo("Area code must be between 1 and 999!");
    }

    @Test
    void when_instantiated_with_invalid_serial_code_throws_appropriate_PhoneNumberException() {
        PhoneNumber.PhoneNumberException ex = assertThrows(PhoneNumber.PhoneNumberException.class, () -> new PhoneNumber(1, 1, "", 0, PhoneType.MOBILE));
        assertThat(ex.getMessage()).isEqualTo("Serial code must not be null or blank!");
    }

    @Test
    void when_instantiated_with_invalid_extension_throws_appropriate_PhoneNumberException() {
        PhoneNumber.PhoneNumberException ex = assertThrows(PhoneNumber.PhoneNumberException.class, () -> new PhoneNumber(1, 1, "1234567890", -1, PhoneType.MOBILE));
        assertThat(ex.getMessage()).isEqualTo("Extension must be between 0 and 9999!");
    }
}












