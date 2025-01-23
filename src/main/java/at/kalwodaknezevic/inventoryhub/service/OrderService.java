package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Order;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import at.kalwodaknezevic.inventoryhub.foundation.JavaTimeFactory;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import at.kalwodaknezevic.inventoryhub.persistance.OrderRepository;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))

@Service
// TODO add @Transactional(readOnly=true) annotation
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final SupplierRepository supplierRepository;
    private final EmployeeRepository employeeRepository;
    private final JavaTimeFactory javaTimeFactory;

    @Transactional
    public Order createOrder(Supplier.SupplierId supplierId, Employee.EmployeeId employeeId, LocalDate deliveryDate) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));

        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new NoSuchElementException("Supplier not found"));

        var now = javaTimeFactory.today();
        Order order = Order.builder()
                .employees(employee)
                .supplier(supplier)
                .orderDate(now)
                .deliveryDate(deliveryDate)
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(Long orderId) {
        return orderRepository.findById(new Order.OrderId(orderId));
    }
}
