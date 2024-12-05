package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;
import at.kalwodaknezevic.inventoryhub.domain.PhoneType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.Optional;

@Converter(autoApply = true)
public class PhoneNumberConverter implements AttributeConverter<PhoneNumber, String> {

    @Override
    public String convertToDatabaseColumn(PhoneNumber phoneNumber) {
        return Optional.ofNullable(phoneNumber)
                .map(pn -> String.format("%d-%d-%s-%d-%s",
                        pn.countryCode(),
                        pn.areaCode(),
                        pn.serialCode(),
                        pn.extension(),
                        pn.phoneType()))
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public PhoneNumber convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        String[] parts = dbData.split("-");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid phone number data: " + dbData);
        }
        return new PhoneNumber(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                parts[2],
                Integer.parseInt(parts[3]),
                PhoneType.valueOf(parts[4])
        );
    }
}