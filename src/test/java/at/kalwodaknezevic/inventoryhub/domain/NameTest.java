package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void when_instantiated_with_null_throws_appropriate_TitleException() {
        Name.NameException ex = assertThrows(Name.NameException.class, () -> new Name(null));
        assertThat(ex.getMessage()).isEqualTo("Name value must not be null!");
    }

    @Test
    void when_instantiated_with_to_long_value_throws_appropriate_TitleException() {
        assertThatThrownBy(() -> new Name("This is a very long title that is longer than 50 characters!"))
                .isInstanceOf(Name.NameException.class)
                .hasMessage("Name value must not be longer than 50 characters!");
    }

    @Test
    void when_instantiated_with_to_short_value_throws_appropriate_TitleException() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(Name.NameException.class)
                .hasMessage("Name value must not be shorter than 1 characters!");
    }
}