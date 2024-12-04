/*
package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Address;
import at.kalwodaknezevic.inventoryhub.domain.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.Optional;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<Address, String> {
    @Override
    public String convertToDatabaseColumn(Address address) {
        return Optional.ofNullable(address)
                .map(Address::address)
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public Address convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return new Email(s);
    }
}
*/