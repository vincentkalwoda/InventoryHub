package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.commands.OrderCommands.CreateOrderCommand;
import at.kalwodaknezevic.inventoryhub.domain.*;
import at.kalwodaknezevic.inventoryhub.foundation.JavaTimeFactory;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import at.kalwodaknezevic.inventoryhub.persistance.OrderRepository;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    private @Mock OrderRepository orderRepository;
    private @Mock SupplierRepository supplierRepository;
    private @Mock EmployeeRepository employeeRepository;
    private @Mock JavaTimeFactory javaTimeFactory;

    private OrderService orderService;
    private Employee employee;
    private Supplier supplier;
    private Article article;
    private Order order;
    private CreateOrderCommand createOrderCommand;

    @BeforeEach
    void setUp() {
        assumeThat(orderRepository).isNotNull();
        assumeThat(supplierRepository).isNotNull();
        assumeThat(employeeRepository).isNotNull();
        assumeThat(javaTimeFactory).isNotNull();
        orderService = new OrderService(orderRepository, supplierRepository, employeeRepository, javaTimeFactory);
        Address address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        employee = FixturesFactory.johnDoeEmployee(address);
        supplier = FixturesFactory.johnDoeSupplier(address);
        article = FixturesFactory.article();
        order = FixturesFactory.order(supplier, employee, article);
        createOrderCommand = FixturesFactory.createOrderCommand(order);
    }

    @Test
    void cant_create_order_with_missing_employee() {
        when(employeeRepository.findById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> orderService.createOrder(createOrderCommand))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Employee not found");
    }

    @Test
    void cant_create_order_with_missing_supplier() {
        when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));
        when(supplierRepository.findById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> orderService.createOrder(createOrderCommand))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Supplier not found");
    }

    @Test
    void can_create_order_with_existing_employee_and_supplier() {
        when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));
        when(supplierRepository.findById(any())).thenReturn(Optional.of(supplier));
        when(orderRepository.findByApiKey(any(ApiKey.class))).thenReturn(Optional.empty());
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        var createdOrder = orderService.createOrder(createOrderCommand);

        assertThat(createdOrder).isEqualTo(order);
    }

    @Test
    void can_get_all_orders() {
        when(orderRepository.findAll()).thenReturn(List.of(order));

        var orders = orderService.getAll();
        assertThat(orders).containsExactly(order);
    }

    @Test
    void can_get_order() {
        when(orderRepository.findById(order.getOrderId())).thenReturn(java.util.Optional.of(order));

        var foundOrder = orderService.getOrder(order.getOrderId().id());
        assertThat(foundOrder).isPresent().contains(order);
    }

    @Test
    void can_get_order_items() {
        var orderItem = List.of(FixturesFactory.orderItem(article));
        order.setOrderItems(orderItem);
        when(orderRepository.findById(order.getOrderId())).thenReturn(java.util.Optional.of(order));

        var orderItems = orderService.getOrderItems(order.getOrderId());
        assertThat(orderItems).containsExactlyElementsOf(order.getOrderItems());
    }
}