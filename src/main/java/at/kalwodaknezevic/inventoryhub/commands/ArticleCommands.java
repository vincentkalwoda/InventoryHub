package at.kalwodaknezevic.inventoryhub.commands;

public class ArticleCommands {
    public record CreateArticleCommand(
            String name,
            String description,
            String category,
            Float price,
            Integer quantity
    ) {
    }

    public record UpdateArticleCommand(
            Long articleId,
            String name,
            String description,
            String category,
            Float price,
            Integer quantity
    ) {
    }

    public record DeleteArticleCommand(
            Long articleId
    ) {
    }
}