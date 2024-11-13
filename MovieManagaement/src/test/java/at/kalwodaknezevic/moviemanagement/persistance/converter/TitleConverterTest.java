package at.kalwodaknezevic.moviemanagement.persistance.converter;

import at.kalwodaknezevic.moviemanagement.domain.Title;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TitleConverterTest {

    private TitleConverter titleConverter = new TitleConverter();

    @Test
    void when_convert_a_valid_title_to_db_value_returns_content() {
        // arrange / given
        String value = "The Matrix";
        Title title = new Title("The Matrix");

        // act / when
        String convertedValue = titleConverter.convertToDatabaseColumn(title);

        // assert / then
        assertThat(convertedValue).isEqualTo(value);
    }

    @Test
    void when_convert_a_null_title_to_db_value_returns_null() {
        // expect
        assertThat(titleConverter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void when_convert_a_valid_title_value_to_a_title_instance() {
        // arrange / given
        String value = "The Matrix";

        // act / when
        var title = titleConverter.convertToEntityAttribute(value);

        // assert / then
        assertThat(title.titleValue()).isEqualTo(value);
    }

    @Test
    void when_convert_a_null_title_value_to_a_title_returns_null() {
        // expect
        assertThat(titleConverter.convertToEntityAttribute(null)).isNull();
    }
}