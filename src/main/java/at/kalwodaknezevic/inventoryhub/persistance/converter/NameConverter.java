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
                .map(Name::value)
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public Name convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return new Name(dbData);
    }
}
