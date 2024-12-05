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
    @OneToMany
    private List<Article> orderItems;
    @ManyToOne
    private Supplier supplier;
    @NotNull
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private OrderStatus orderStatus;

    @Embeddable
    public record OrderId(@GeneratedValue @NotNull Long id) {
    }
}
