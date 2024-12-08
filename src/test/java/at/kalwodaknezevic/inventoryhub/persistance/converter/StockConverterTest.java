package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Stock;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StockConverterTest {

    private final StockConverter stockConverter = new StockConverter();

    @Test
    void when_convert_a_valid_stock_to_db_data_returns_content() {
        // arrange
        Stock stock = new Stock(new Article(new Article.ArticleId(1L), null, null, null, null), 10);
        String expectedValue = "1,10";

        // act
        var convertedValue = stockConverter.convertToDatabaseColumn(stock);

        // assert
        assertThat(convertedValue).isEqualTo(expectedValue);
    }

    @Test
    void when_convert_a_null_stock_to_db_data_returns_null() {
        // expect
        assertThat(stockConverter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void when_convert_a_valid_stock_value_to_a_stock_instance() {
        // arrange
        String dbData = "1,10";

        // act
        var convertedValue = stockConverter.convertToEntityAttribute(dbData);

        // assert
        assertThat(convertedValue.article().getArticleId().id()).isEqualTo(1L);
        assertThat(convertedValue.quantity()).isEqualTo(10);
    }

    @Test
    void when_convert_a_null_stock_value_to_a_stock_returns_null() {
        // expect
        assertThat(stockConverter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    void when_convert_an_invalid_stock_value_to_a_stock_throws_exception() {
        // expect
        assertThatThrownBy(() -> stockConverter.convertToEntityAttribute("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}