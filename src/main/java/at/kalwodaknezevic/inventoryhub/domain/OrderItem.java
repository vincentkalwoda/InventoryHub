package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_order_item_article"))
    @NotNull
    Article article;

    @Min(1)
    @NotNull
    int quantity;
}

