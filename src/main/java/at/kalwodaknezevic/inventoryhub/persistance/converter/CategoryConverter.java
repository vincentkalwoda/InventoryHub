package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Category;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, Character> {

    static final String VALID_VALUES = "'E', 'F', 'C', 'T', 'L', 'O'";
    public static final String COLUMN_DEFINITION = "enum (" + VALID_VALUES + ")";

    @Override
    public Character convertToDatabaseColumn(Category attribute) {
        return switch (attribute) {
            case ELECTRONICS -> 'E';
            case FURNITURE -> 'F';
            case CLOTHING -> 'C';
            case TOYS -> 'T';
            case TOOLS -> 'L';
            case OTHER -> 'O';
            case null -> null;
        };
    }

    @Override
    public Category convertToEntityAttribute(Character dbData) {
        return switch (dbData) {
            case 'E' -> Category.ELECTRONICS;
            case 'F' -> Category.FURNITURE;
            case 'C' -> Category.CLOTHING;
            case 'T' -> Category.TOYS;
            case 'L' -> Category.TOOLS;
            case 'O' -> Category.OTHER;
            case null -> null;
            default -> throw new IllegalArgumentException("Unknown category: " + dbData);
        };
    }
}