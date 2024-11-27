package at.kalwodaknezevic.inventoryhub.domain;

public record Stock(Article article, int quantity) {
    public Stock {
        if (article == null) throw StockException.forNullArticle();
        if (quantity < 0) throw StockException.forNegativeQuantity();
    }

    public static class StockException extends RuntimeException {
        private StockException(String message) {
            super(message);
        }

        static StockException forNullArticle() {
            return new StockException("Article must not be null!");
        }

        static StockException forNegativeQuantity() {
            return new StockException("Quantity must not be negative!");
        }
    }
}
