package avajlauncher.Exceptions;

public class InvalidNumberOfSimulations extends Exception {
    public InvalidNumberOfSimulations(String message) {
        super(message);
    }

    public InvalidNumberOfSimulations(String message, Throwable err) {
        super(message, err);
    }
}