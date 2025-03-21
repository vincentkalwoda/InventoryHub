package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.OrderCommands.CreateOrderCommand;
import at.kalwodaknezevic.inventoryhub.domain.*;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.foundation.JavaTimeFactory;
import at.kalwodaknezevic.inventoryhub.persistance.ArticleRepository;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import at.kalwodaknezevic.inventoryhub.persistance.OrderRepository;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import at.kalwodaknezevic.inventoryhub.presentation.www.CreateOrderForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))

@Service
// TODO add @Transactional(readOnly=true) annotation
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final SupplierRepository supplierRepository;
    private final EmployeeRepository employeeRepository;
    private final JavaTimeFactory javaTimeFactory;
    private final ArticleRepository articleRepository;

    @Transactional
    public Order createOrder(CreateOrderCommand command) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("o_" + Base58.random(16));
        } while (orderRepository.findByApiKey(apiKey).isPresent());

        Employee employee = employeeRepository.findById(command.employee().getEmployeeId())
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));

        Supplier supplier = supplierRepository.findById(command.supplier().getSupplierId())
                .orElseThrow(() -> new NoSuchElementException("Supplier not found"));

        Order order = Order.builder()
                .apiKey(apiKey)
                .employee(employee)
                .supplier(supplier)
                .orderDate(command.orderDate())
                .deliveryDate(command.deliveryDate())
                .orderStatus(command.orderStatus())
                .orderItems(command.orderItems())
                .build();

        return orderRepository.save(order);
    }

    public Order createOrder(CreateOrderForm form) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("o_" + Base58.random(16));
        } while (orderRepository.findByApiKey(apiKey).isPresent());

        Employee employee = employeeRepository.findById(form.getEmployee().getEmployeeId())
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));

        Supplier supplier = supplierRepository.findById(form.getSupplier().getSupplierId())
                .orElseThrow(() -> new NoSuchElementException("Supplier not found"));

        List<OrderItem> orderItems = form.getOrderItems().stream()
                .map(itemForm -> new OrderItem(
                        articleRepository.findById(itemForm.getArticleId())
                                .orElseThrow(() -> new NoSuchElementException("Article not found")),
                        itemForm.getQuantity()))
                .collect(Collectors.toList());

        Order order = Order.builder()
                .apiKey(apiKey)
                .employee(employee)
                .supplier(supplier)
                .orderDate(form.getOrderDate())
                .deliveryDate(form.getDeliveryDate())
                .orderStatus(OrderStatus.PENDING)
                .orderItems(orderItems)
                .build();

        return orderRepository.save(order);
    }

    public void deleteOrder(String apiKey) {
        Order order = orderRepository.findByApiKey(new ApiKey(apiKey)).get();
        orderRepository.delete(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(String apiKey) {
        return orderRepository.findByApiKey(new ApiKey(apiKey));
    }

    public List<OrderItem> getOrderItems(String apiKey) {
        return orderRepository.findByApiKey(new ApiKey(apiKey)).get().getOrderItems();
    }
}
