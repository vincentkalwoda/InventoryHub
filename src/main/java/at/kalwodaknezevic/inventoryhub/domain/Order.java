package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class Order {
    @EmbeddedId
    private OrderId orderId;
    @NotNull
    private List<Article> orderItems;
    @NotNull
    private Supplier supplier;
    @NotNull
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private OrderStatus orderStatus;

    @Embeddable
    public record OrderId(@GeneratedValue @NotNull Long id) {
    }
}
