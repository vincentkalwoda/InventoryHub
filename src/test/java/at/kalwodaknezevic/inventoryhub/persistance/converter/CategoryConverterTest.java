package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryConverterTest {

    private final CategoryConverter categoryConverter = new CategoryConverter();

    @Test
    void when_convert_a_valid_category_to_db_value_returns_content() {
        // arrange / given
        Character value = 'E';
        Category category = Category.ELECTRONICS;

        // act / when
        Character convertedValue = categoryConverter.convertToDatabaseColumn(category);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_null_category_to_db_value_returns_null() {
        // expect
        assertNull(categoryConverter.convertToDatabaseColumn(null));
    }

    @Test
    void when_convert_a_valid_category_value_to_a_category_instance() {
        // arrange / given
        Character value = 'E';

        // act / when
        var category = categoryConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(Category.ELECTRONICS, category);
    }

    @Test
    void when_convert_a_null_category_value_to_a_category_returns_null() {
        // expect
        assertNull(categoryConverter.convertToEntityAttribute(null));
    }
}