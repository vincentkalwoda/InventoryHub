package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Order;
import at.kalwodaknezevic.inventoryhub.domain.OrderStatus;

import java.time.LocalDate;

public record OrderDto(
        SupplierDto supplier,
        EmployeeDto employee,
        LocalDate orderDate,
        LocalDate deliveryDate,
        OrderStatus orderStatus,
        OrderItemDto[] orderItems) {

    public OrderDto(Order o) {
        this(new SupplierDto(o.getSupplier()),
                new EmployeeDto(o.getEmployee()),
                o.getOrderDate(),
                o.getDeliveryDate(),
                o.getOrderStatus(),
                o.getOrderItems()
                        .stream()
                        .map(OrderItemDto::new)
                        .toArray(OrderItemDto[]::new));
    }

    public OrderDto(SupplierDto supplier, EmployeeDto employee, LocalDate orderDate, LocalDate deliveryDate, OrderStatus orderStatus, OrderItemDto[] orderItems) {
        this.supplier = supplier;
        this.employee = employee;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
    }

}
