package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Country;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.Optional;

@Converter(autoApply = true)
public class CountryConverter implements AttributeConverter<Country, String> {

    @Override
    public String convertToDatabaseColumn(Country country) {
        return Optional.ofNullable(country)
                .map(c -> c.name() + c.iso2Code() + c.iso3Code() + (c.areaCode() != null ? c.areaCode() : ""))
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public Country convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case null -> null;
            default -> new Country(dbData);
        };
    }
}
