package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class OrderItem {
    @NotNull
    @ManyToOne
    private Article article;

    @NotNull
    @Min(1)
    private int quantity;
}

