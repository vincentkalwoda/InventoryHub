package at.kalwodaknezevic.inventoryhub.commands;

import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.OrderItem;
import at.kalwodaknezevic.inventoryhub.domain.OrderStatus;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;

import java.time.LocalDate;
import java.util.List;

public class OrderCommands {
    public record CreateOrderCommand(
            List<OrderItem> orderItems,
            Supplier supplier,
            LocalDate orderDate,
            LocalDate deliveryDate,
            OrderStatus orderStatus,
            Employee employee
    ) {
    }

    public record UpdateOrderCommand(
            Long orderId,
            List<OrderItem> orderItems,
            Supplier supplier,
            LocalDate orderDate,
            LocalDate deliveryDate,
            OrderStatus orderStatus,
            Employee employee
    ) {
    }

    public record DeleteOrderCommand(
            Long orderId
    ) {
    }
}