package at.kalwodaknezevic.moviemanagement.persistance.converter;

import at.kalwodaknezevic.moviemanagement.domain.Title;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.Optional;

@Converter(autoApply = true)
public class TitleConverter implements AttributeConverter<Title, String> {

    @Override
    public String convertToDatabaseColumn(Title title) {
        return Optional.ofNullable(title)
                .map(Title::titleValue)
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public Title convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case null -> null;
            default -> new Title(dbData);
        };
    }
}
