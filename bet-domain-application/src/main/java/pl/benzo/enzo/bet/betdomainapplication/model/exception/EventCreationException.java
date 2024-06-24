package pl.benzo.enzo.bet.betdomainapplication.model.exception;

public class EventCreationException extends RuntimeException {
    public EventCreationException(String message) {
        super(message);
    }

    public EventCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
