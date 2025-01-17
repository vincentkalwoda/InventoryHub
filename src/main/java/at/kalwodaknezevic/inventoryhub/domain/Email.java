package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public record Email(String value) {
    public Email {
        if(value == null) throw EmailException.forNullValue();
        if (!value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) throw EmailException.forInvalidValue();
    }

    public static class EmailException extends RuntimeException {
        private EmailException(String message) {
            super(message);
        }

        static Email.EmailException forNullValue() {
            return new Email.EmailException("Email value must not be null!");
        }

        static Email.EmailException forInvalidValue() {
            return new Email.EmailException("Email value is invalid!");
        }
    }
}
