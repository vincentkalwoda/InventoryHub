package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.AddressType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<AddressType, Character> {

    static final String VALID_VALUES = "'B', 'S'";
    public static final String COLUMN_DEFINITION = "enum (" + VALID_VALUES + ")";

    @Override
    public Character convertToDatabaseColumn(AddressType attribute) {
        return switch (attribute) {
            case BILLING -> 'B';
            case SHIPPING -> 'S';
            case null -> null;
        };
    }

    @Override
    public AddressType convertToEntityAttribute(Character dbData) {
        return switch (dbData) {
            case 'B' -> AddressType.BILLING;
            case 'S' -> AddressType.SHIPPING;
            case null -> null;
            default -> throw new IllegalArgumentException("Unknown address type: " + dbData);
        };
    }
}