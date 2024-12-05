package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.PhoneType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PhoneTypeConverter implements AttributeConverter<PhoneType, Integer> {

    static final String VALID_VALUES = "0, 1, 2, 3, 4";
    public static final String COLUMN_DEFINITION = "enum ("+VALID_VALUES+")";

    @Override
    public Integer convertToDatabaseColumn(PhoneType attribute) {
        return switch (attribute) {
            case PhoneType.HOME -> 0;
            case PhoneType.MOBILE -> 1;
            case PhoneType.WORK -> 2;
            case PhoneType.FAX -> 3;
            case PhoneType.OTHER -> 4;
            case null -> null;
        };
    }

    @Override
    public PhoneType convertToEntityAttribute(Integer dbData) {
        return switch (dbData) {
            case 0 -> PhoneType.HOME;
            case 1 -> PhoneType.MOBILE;
            case 2 -> PhoneType.WORK;
            case 3 -> PhoneType.FAX;
            case 4 -> PhoneType.OTHER;
            case null -> null;
            default -> throw new IllegalArgumentException("Unknown phone type: " + dbData);
        };
    }

}
