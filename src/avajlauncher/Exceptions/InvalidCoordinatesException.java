package avajlauncher.Exceptions;

public class InvalidCoordinatesException extends Exception {
    public InvalidCoordinatesException(String message) {
        super(message);
    }

    public InvalidCoordinatesException(String message, Throwable err) {
        super(message, err);
    }
}
