package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Name;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.Optional;

@Converter(autoApply = true)
public class NameConverter implements AttributeConverter<Name, String> {

    @Override
    public String convertToDatabaseColumn(Name title) {
        return Optional.ofNullable(title)
                .map(Name::nameValue)
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public Name convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case null -> null;
            default -> new Name(dbData);
        };
    }
}
