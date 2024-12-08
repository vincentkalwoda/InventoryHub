package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.PhoneType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PhoneTypeConverter implements AttributeConverter<PhoneType, Character> {

    static final String VALID_VALUES = "H, M, W, F, O";
    public static final String COLUMN_DEFINITION = "enum ("+VALID_VALUES+")";

    @Override
    public Character convertToDatabaseColumn(PhoneType attribute) {
        return switch (attribute) {
            case PhoneType.HOME -> 'H';
            case PhoneType.MOBILE -> 'M';
            case PhoneType.WORK -> 'W';
            case PhoneType.FAX -> 'F';
            case PhoneType.OTHER -> 'O';
            case null -> null;
        };
    }

    @Override
    public PhoneType convertToEntityAttribute(Character dbData) {
        return switch (dbData) {
            case 'H' -> PhoneType.HOME;
            case 'M' -> PhoneType.MOBILE;
            case 'W' -> PhoneType.WORK;
            case 'F' -> PhoneType.FAX;
            case 'O' -> PhoneType.OTHER;
            case null -> null;
            default -> throw new IllegalArgumentException("Unknown phone type: " + dbData);
        };
    }

}
