package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryConverterTest {

    private final CategoryConverter categoryConverter = new CategoryConverter();

    @Test
    void when_convert_a_valid_category_electronics_to_db_value_returns_content() {
        // arrange / given
        Character value = 'E';
        Category category = Category.ELECTRONICS;

        // act / when
        Character convertedValue = categoryConverter.convertToDatabaseColumn(category);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_category_furniture_to_db_value_returns_content() {
        // arrange / given
        Character value = 'F';
        Category category = Category.FURNITURE;

        // act / when
        Character convertedValue = categoryConverter.convertToDatabaseColumn(category);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_category_clothing_to_db_value_returns_content() {
        // arrange / given
        Character value = 'C';
        Category category = Category.CLOTHING;

        // act / when
        Character convertedValue = categoryConverter.convertToDatabaseColumn(category);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_category_toys_to_db_value_returns_content() {
        // arrange / given
        Character value = 'T';
        Category category = Category.TOYS;

        // act / when
        Character convertedValue = categoryConverter.convertToDatabaseColumn(category);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_category_tools_to_db_value_returns_content() {
        // arrange / given
        Character value = 'L';
        Category category = Category.TOOLS;

        // act / when
        Character convertedValue = categoryConverter.convertToDatabaseColumn(category);

        // assert / then
        assertEquals(convertedValue, value);
    }

    @Test
    void when_convert_a_valid_category_other_to_db_value_returns_content() {
        // arrange / given
        Character value = 'O';
        Category category = Category.OTHER;

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
    void when_convert_a_valid_category_electronics_value_to_a_category_instance() {
        // arrange / given
        Character value = 'E';

        // act / when
        var category = categoryConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(Category.ELECTRONICS, category);
    }

    @Test
    void when_convert_a_valid_category_furniture_value_to_a_category_instance() {
        // arrange / given
        Character value = 'F';

        // act / when
        var category = categoryConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(Category.FURNITURE, category);
    }

    @Test
    void when_convert_a_valid_category_clothing_value_to_a_category_instance() {
        // arrange / given
        Character value = 'C';

        // act / when
        var category = categoryConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(Category.CLOTHING, category);
    }

    @Test
    void when_convert_a_valid_category_toys_value_to_a_category_instance() {
        // arrange / given
        Character value = 'T';

        // act / when
        var category = categoryConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(Category.TOYS, category);
    }

    @Test
    void when_convert_a_valid_category_tools_value_to_a_category_instance() {
        // arrange / given
        Character value = 'L';

        // act / when
        var category = categoryConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(Category.TOOLS, category);
    }

    @Test
    void when_convert_a_valid_category_other_value_to_a_category_instance() {
        // arrange / given
        Character value = 'O';

        // act / when
        var category = categoryConverter.convertToEntityAttribute(value);

        // assert / then
        assertEquals(Category.OTHER, category);
    }

    @Test
    void when_convert_a_null_category_value_to_a_category_returns_null() {
        // expect
        assertNull(categoryConverter.convertToEntityAttribute(null));
    }

    @Test
    void when_convert_an_invalid_category_value_to_a_category_throws_exception() {
        // expect
        assertThrows(IllegalArgumentException.class, () -> categoryConverter.convertToEntityAttribute('X'));
    }
}