package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.domain.Order;
import at.kalwodaknezevic.inventoryhub.dtos.OrderDto;
import at.kalwodaknezevic.inventoryhub.dtos.OrderItemDto;
import at.kalwodaknezevic.inventoryhub.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(ApiConstants.API + "/orders")
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll()
                .stream()
                .map(OrderDto::new)
                .toList());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        return orderService.getOrder(orderId)
                .map(OrderDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{orderId}/orderItems")
    public ResponseEntity<List<OrderItemDto>> getOrderItems(@PathVariable Order.OrderId orderId) {
        return ResponseEntity.ok(orderService.getOrderItems(orderId)
                .stream()
                .map(OrderItemDto::new)
                .toList());
    }
}
