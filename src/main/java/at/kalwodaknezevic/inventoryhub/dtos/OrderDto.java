package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Order;
import at.kalwodaknezevic.inventoryhub.domain.OrderStatus;

import java.time.LocalDate;

public record OrderDto(
        String apiKey,
        SupplierDto supplier,
        EmployeeDto employee,
        LocalDate orderDate,
        LocalDate deliveryDate,
        OrderStatus orderStatus,
        OrderItemDto[] orderItems) {

    public OrderDto(Order o) {
        this(
                o.getApiKey().value(),
                new SupplierDto(o.getSupplier()),
                new EmployeeDto(o.getEmployee()),
                o.getOrderDate(),
                o.getDeliveryDate(),
                o.getOrderStatus(),
                o.getOrderItems()
                        .stream()
                        .map(OrderItemDto::new)
                        .toArray(OrderItemDto[]::new));
    }
}
