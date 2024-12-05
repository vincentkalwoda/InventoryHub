package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Stock;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StockConverter implements AttributeConverter<Stock, String> {

    @Override
    public String convertToDatabaseColumn(Stock stock) {
        if (stock == null) {
            return null;
        }
        return String.format("%s,%d",
                stock.article().getArticleId().id(),
                stock.quantity());
    }

    @Override
    public Stock convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        String[] parts = dbData.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid stock data: " + dbData);
        }
        return new Stock(
                new Article(new Article.ArticleId(Long.parseLong(parts[0])), null, null, null, null),
                Integer.parseInt(parts[1])
        );
    }
}