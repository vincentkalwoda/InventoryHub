package at.kalwodaknezevic.inventoryhub.domain;

public record Name(String firstname, String lastname) {

    private static int MIN_LENGTH = 1;
    private static int MAX_LENGTH = 50;

    public Name {
        if(firstname == null) throw NameException.forNullValue("Firstname");
        if(firstname.length() < MIN_LENGTH) throw NameException.forLongValue("Firstname");
        if(firstname.length() > MAX_LENGTH) throw NameException.forShortValue("Firstname");

        if(lastname == null) throw NameException.forNullValue("Lastname");
        if(lastname.length() < MIN_LENGTH) throw NameException.forLongValue("Lastname");
        if(lastname.length() > MAX_LENGTH) throw NameException.forShortValue("Lastname");
    }

    public static class NameException extends RuntimeException {
        private NameException(String message) {
            super(message);
        }

        static NameException forNullValue(String field) {
            return new NameException(field + " must not be null!");
        }

        static NameException forShortValue(String field) {
            return new NameException(field + " must not be longer than %d characters!".formatted(MAX_LENGTH));
        }

        static NameException forLongValue(String field) {
            return new NameException(field + " must not be shorter than %d characters!".formatted(MIN_LENGTH));
        }
    }
}