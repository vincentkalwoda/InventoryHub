package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.OrderStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Character> {

    static final String VALID_VALUES = "'P', 'S', 'D', 'C'";
    public static final String COLUMN_DEFINITION = "enum (" + VALID_VALUES + ")";

    @Override
    public Character convertToDatabaseColumn(OrderStatus attribute) {
        return switch (attribute) {
            case PENDING -> 'P';
            case SHIPPED -> 'S';
            case DELIVERED -> 'D';
            case CANCELLED -> 'C';
            case null -> null;
        };
    }

    @Override
    public OrderStatus convertToEntityAttribute(Character dbData) {
        return switch (dbData) {
            case 'P' -> OrderStatus.PENDING;
            case 'S' -> OrderStatus.SHIPPED;
            case 'D' -> OrderStatus.DELIVERED;
            case 'C' -> OrderStatus.CANCELLED;
            case null -> null;
            default -> throw new IllegalArgumentException("Unknown order status: " + dbData);
        };
    }
}