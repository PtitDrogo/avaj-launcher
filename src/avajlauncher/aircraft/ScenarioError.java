package avajlauncher.aircraft;

public class ScenarioError extends Exception {
    public ScenarioError(String message) {
        super(message);
    }

    public ScenarioError(String message, Throwable err) {
        super(message, err);
    }
}
