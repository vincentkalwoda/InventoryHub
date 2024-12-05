package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Address;
import at.kalwodaknezevic.inventoryhub.domain.AddressType;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<Address, String> {

    @Override
    public String convertToDatabaseColumn(Address address) {
        if (address == null) {
            return null;
        }
        return String.format("%s,%s,%s,%s,%s",
                address.street(),
                address.city(),
                address.zipCode(),
                address.country().getName(),
                address.addressType());
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        String[] parts = dbData.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid address data: " + dbData);
        }
        return new Address(
                parts[0],
                parts[1],
                parts[2],
                new Country(parts[3], null, null, null),
                AddressType.valueOf(parts[4])
        );
    }
}