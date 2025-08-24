package avajlauncher.Exceptions;

public class UnsupportedFlyableException extends Exception {
    public UnsupportedFlyableException(String message) {
        super(message);
    }

    public UnsupportedFlyableException(String message, Throwable err) {
        super(message, err);
    }
}
