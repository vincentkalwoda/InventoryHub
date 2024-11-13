package at.kalwodaknezevic.inventoryhub.domain;

/*
* Represents a type-safe Name following the rules below:
*
* - does not accept null values
* - restricts to values longer than 50 characters
*
* @param nameValue
* @throws NameException
*/

public record Name(String nameValue) {

    private static int MIN_LENGTH = 1;
    private static int MAX_LENGTH = 50;

    public Name {
        if(nameValue == null) throw NameException.forNullValue();
        if(nameValue.length() < MIN_LENGTH) throw NameException.forLongValue();
        if(nameValue.length() > MAX_LENGTH) throw NameException.forShortValue();
    }

    public static class NameException extends RuntimeException {
        private NameException(String message) {
            super(message);
        }

        static NameException forNullValue() {
            return new NameException("Name value must not be null!");
        }

        static NameException forShortValue() {
            return new NameException("Name value must not be longer than %d characters!".formatted(MAX_LENGTH));
        }

        static NameException forLongValue() {
            return new NameException("Name value must not be shorter than %d characters!".formatted(MIN_LENGTH));
        }
    }
}
