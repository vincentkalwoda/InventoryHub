package at.kalwodaknezevic.inventoryhub.domain;

public record ApiKey(
        String value
) {
    public ApiKey {
        if (value == null) throw ApiKeyException.forNullValue();
    }

    public static class ApiKeyException extends RuntimeException {
        private ApiKeyException(String message) {
            super(message);
        }

        static ApiKey.ApiKeyException forNullValue() {
            return new ApiKey.ApiKeyException("Api key value must not be null!");
        }

        static ApiKey.ApiKeyException forInvalidValue() {
            return new ApiKey.ApiKeyException("Api key value is invalid!");
        }
    }
}