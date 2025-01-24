package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Order;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import at.kalwodaknezevic.inventoryhub.foundation.JavaTimeFactory;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import at.kalwodaknezevic.inventoryhub.persistance.OrderRepository;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
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

    @BeforeEach
    void setUp() {
        assumeThat(orderRepository).isNotNull();
        assumeThat(supplierRepository).isNotNull();
        assumeThat(employeeRepository).isNotNull();
        assumeThat(javaTimeFactory).isNotNull();
        orderService = new OrderService(orderRepository, supplierRepository, employeeRepository, javaTimeFactory);
    }

    @Test
    void cant_create_order_with_missing_employee() {
        when(employeeRepository.findById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> orderService.createOrder(new Supplier.SupplierId(1l), new Employee.EmployeeId(1l), null))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Employee not found");
    }

    @Test
    void cant_create_order_with_missing_supplier() {
        var employee = FixturesFactory.johnDoeEmployee(FixturesFactory.spengergasse20(FixturesFactory.austria()));
        when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));
        when(supplierRepository.findById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> orderService.createOrder(new Supplier.SupplierId(1l), new Employee.EmployeeId(1l), null))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Supplier not found");
    }

    @Test
    void can_create_order_with_existing_employee_and_supplier() {
        var employee = FixturesFactory.johnDoeEmployee(FixturesFactory.spengergasse20(FixturesFactory.austria()));
        var supplier = FixturesFactory.johnDoeSupplier(FixturesFactory.spengergasse20(FixturesFactory.austria()));
        when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));
        when(supplierRepository.findById(any())).thenReturn(Optional.of(supplier));
        when(javaTimeFactory.today()).thenReturn(LocalDate.of(2025, Month.JANUARY, 23));
        when(orderRepository.save(any(Order.class))).then(AdditionalAnswers.returnsFirstArg());

        var order = orderService.createOrder(new Supplier.SupplierId(1l), new Employee.EmployeeId(1l), null);

        assertThat(order).isNotNull();
    }

    @Test
    void can_get_all_orders() {
        var order = FixturesFactory.order(FixturesFactory.johnDoeSupplier(FixturesFactory.spengergasse20(FixturesFactory.austria())), FixturesFactory.johnDoeEmployee(FixturesFactory.spengergasse20(FixturesFactory.austria())));
        when(orderRepository.findAll()).thenReturn(java.util.List.of(order));

        var orders = orderService.getAll();
        assertThat(orders).containsExactly(order);
    }

    @Test
    void can_get_order() {
        var order = FixturesFactory.order(FixturesFactory.johnDoeSupplier(FixturesFactory.spengergasse20(FixturesFactory.austria())), FixturesFactory.johnDoeEmployee(FixturesFactory.spengergasse20(FixturesFactory.austria())));
        when(orderRepository.findById(order.getOrderId())).thenReturn(java.util.Optional.of(order));

        var foundOrder = orderService.getOrder(order.getOrderId());
        assertThat(foundOrder).isPresent().contains(order);
    }

    @Test
    void can_get_order_items() {
        var article = FixturesFactory.article();
        var orderItem = List.of(FixturesFactory.orderItem(article));
        var order = FixturesFactory.order(FixturesFactory.johnDoeSupplier(FixturesFactory.spengergasse20(FixturesFactory.austria())), FixturesFactory.johnDoeEmployee(FixturesFactory.spengergasse20(FixturesFactory.austria())));
        order.setOrderItems(orderItem);
        when(orderRepository.findById(order.getOrderId())).thenReturn(java.util.Optional.of(order));

        var orderItems = orderService.getOrderItems(order.getOrderId());
        assertThat(orderItems).containsExactlyElementsOf(order.getOrderItems());
    }
}