package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.OrderItem;

public record OrderItemDto(
        ArticleDto article,
        int quantity) {

    public OrderItemDto(OrderItem o) {
        this(
                new ArticleDto(o.getArticle()),
                o.getQuantity());
    }
}
