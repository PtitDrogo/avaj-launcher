package fortytwo.tfreydie.avajlauncher.Exceptions;

public class InvalidScenarioException extends Exception {
    public InvalidScenarioException(String message) {
        super(message);
    }

    public InvalidScenarioException(String message, Throwable err) {
        super(message, err);
    }
}