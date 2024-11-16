package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameConverterTest {

    private NameConverter nameConverter = new NameConverter();

    @Test
    void when_convert_a_valid_title_to_db_value_returns_content() {
        // arrange / given
        String value = "Article 1";
        Name name = new Name("Article 1");

        // act / when
        String convertedValue = nameConverter.convertToDatabaseColumn(name);

        // assert / then
        assertThat(convertedValue).isEqualTo(value);
    }

    @Test
    void when_convert_a_null_title_to_db_value_returns_null() {
        // expect
        assertThat(nameConverter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void when_convert_a_valid_title_value_to_a_title_instance() {
        // arrange / given
        String value = "Article 1";

        // act / when
        var name = nameConverter.convertToEntityAttribute(value);

        // assert / then
        assertThat(name.nameValue()).isEqualTo(value);
    }

    @Test
    void when_convert_a_null_title_value_to_a_title_returns_null() {
        // expect
        assertThat(nameConverter.convertToEntityAttribute(null)).isNull();
    }
}