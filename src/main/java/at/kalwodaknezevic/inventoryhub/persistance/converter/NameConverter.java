package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Name;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.Optional;

@Converter(autoApply = true)
public class NameConverter implements AttributeConverter<Name, String> {

    @Override
    public String convertToDatabaseColumn(Name name) {
        return Optional.ofNullable(name)
                .map(n -> n.firstname() + " " + n.lastname())
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public Name convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(" ");
        return new Name(parts[0], parts[1]);
    }
}