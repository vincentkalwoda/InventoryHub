package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void testNameAssertions() {
        Name name = new Name("John", "Doe");

        assertThat(name)
                .hasValidFirstname()
                .hasValidLastname();
    }

    @Test
    void when_instantiated_with_null_firstname_throws_appropriate_NameException() {
        Name.NameException ex = assertThrows(Name.NameException.class, () -> new Name(null, "Doe"));
        assertThat(ex.getMessage()).isEqualTo("Firstname must not be null!");
    }

    @Test
    void when_instantiated_with_null_lastname_throws_appropriate_NameException() {
        Name.NameException ex = assertThrows(Name.NameException.class, () -> new Name("John", null));
        assertThat(ex.getMessage()).isEqualTo("Lastname must not be null!");
    }

    @Test
    void when_instantiated_with_to_long_firstname_throws_appropriate_NameException() {
        assertThatThrownBy(() -> new Name("This is a very long title that is longer than 50 characters!", "Doe"))
                .isInstanceOf(Name.NameException.class)
                .hasMessage("Firstname must not be longer than 50 characters!");
    }

    @Test
    void when_instantiated_with_to_long_lastname_throws_appropriate_NameException() {
        assertThatThrownBy(() -> new Name("John", "This is a very long title that is longer than 50 characters!"))
                .isInstanceOf(Name.NameException.class)
                .hasMessage("Lastname must not be longer than 50 characters!");
    }

    @Test
    void when_instantiated_with_to_short_firstname_throws_appropriate_NameException() {
        assertThatThrownBy(() -> new Name("", "Doe"))
                .isInstanceOf(Name.NameException.class)
                .hasMessage("Firstname must not be shorter than 1 characters!");
    }

    @Test
    void when_instantiated_with_to_short_lastname_throws_appropriate_NameException() {
        assertThatThrownBy(() -> new Name("John", ""))
                .isInstanceOf(Name.NameException.class)
                .hasMessage("Lastname must not be shorter than 1 characters!");
    }
}