package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
@Entity
@Table(name = "orders")
public class Order {
    @EmbeddedId
    private OrderId orderId;
    @ElementCollection
    @JoinTable(name = "order_items",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "FK_order_item_order")))
    private List<OrderItem> orderItems;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_order_supplier"))
    private Supplier supplier;
    @NotNull
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_order_employee"))
    private Employee employees;


    @Embeddable
    public record OrderId(@GeneratedValue @NotNull Long id) {
    }
}
