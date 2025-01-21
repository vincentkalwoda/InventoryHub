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
    @JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "FK_order_supplier"))
    @NotNull
    private Supplier supplier;

    @NotNull
    private LocalDate orderDate;

    @NotNull
    private LocalDate deliveryDate;

    @NotNull
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "employees_id", foreignKey = @ForeignKey(name = "FK_order_employee"))
    @NotNull
    private Employee employees;

    @Embeddable
    public record OrderId(@GeneratedValue @NotNull Long id) {
    }
}