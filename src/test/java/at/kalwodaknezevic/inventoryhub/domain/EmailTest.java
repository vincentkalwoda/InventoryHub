package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void testEmailAssertions() {
        Email email = new Email("john.doe@spg.at");

        assertThat(email)
                .isValidEmail();
    }

    @Test
    void when_instantiated_with_null_throws_appropriate_EmailException() {
        Email.EmailException ex = assertThrows(Email.EmailException.class, () -> new Email(null));
        assertEquals("Email value must not be null!", ex.getMessage());
    }

    @Test
    void when_instantiated_with_invalid_value_throws_appropriate_EmailException() {
        Email.EmailException ex = assertThrows(Email.EmailException.class, () -> new Email("invalid"));
        assertEquals("Email value is invalid!", ex.getMessage());
    }

    @Test
    void when_instantiated_with_valid_value_does_not_throw_exception() {
        assertDoesNotThrow(() -> new Email("kal210629@spengergasse.at"));
    }
}