package at.kalwodaknezevic.moviemanagement.domain;

/*
* Represents a type-safe Title following the rules below:
*
* - does not accept null values
* - restricts to values longer than 50 characters
*
* @param titleValue
* @throws TitleException
*/

public record Title(String titleValue) {

    private static int MIN_LENGTH = 1;
    private static int MAX_LENGTH = 50;

    public Title {
        if(titleValue == null) throw TitleException.forNullValue();
        if(titleValue.length() < MIN_LENGTH) throw TitleException.forLongValue();
        if(titleValue.length() > MAX_LENGTH) throw TitleException.forShortValue();
    }

    public static class TitleException extends RuntimeException {
        private TitleException(String message) {
            super(message);
        }

        static TitleException forNullValue() {
            return new TitleException("Title value must not be null!");
        }

        static TitleException forShortValue() {
            return new TitleException("Title value must not be longer than %d characters!".formatted(MAX_LENGTH));
        }

        static TitleException forLongValue() {
            return new TitleException("Title value must not be shorter than %d characters!".formatted(MIN_LENGTH));
        }
    }
}
