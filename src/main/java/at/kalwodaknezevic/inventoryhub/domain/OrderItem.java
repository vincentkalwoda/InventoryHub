package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class OrderItem {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_order_item_article"))
    Article article;

    @NotNull
    @Min(1)
    int quantity;
}

