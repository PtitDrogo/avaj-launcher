package fortytwo.tfreydie.avajlauncher.aircraft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fortytwo.tfreydie.avajlauncher.Consts;
import fortytwo.tfreydie.avajlauncher.Exceptions.InvalidCoordinatesException;
import fortytwo.tfreydie.avajlauncher.Exceptions.InvalidNumberOfSimulations;
import fortytwo.tfreydie.avajlauncher.tower.WeatherTower;
import fortytwo.tfreydie.avajlauncher.Exceptions.InvalidScenarioException;
import fortytwo.tfreydie.avajlauncher.Exceptions.UnsupportedFlyableException;

public class ScenarioParser {
    public int processScenario(String[] args, WeatherTower tower) throws InvalidScenarioException {

        try {
            if (args.length != 1) {
                throw new InvalidScenarioException(
                        "Invalid number of arguments for Scenario, expected 1, got " + args.length + ".");
            }
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            int simulations = getNumberOfSimulations(line);

            while ((line = reader.readLine()) != null) {
                processLine(line, tower);
            }
            reader.close();
            return simulations;
        }

        catch (InvalidScenarioException e) {
            throw e;
        } catch (IOException e) {
            throw new InvalidScenarioException("There was an IO Issue with opening the file: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new InvalidScenarioException("Unexpected Error: " + e.getMessage(), e);
        }
    }

    private void processLine(String line, WeatherTower tower) throws InvalidScenarioException, IOException {
        if (line.isEmpty()) {
            throw new InvalidScenarioException("Scenario file cannot have Empty lines");
        }
        String[] words = line.split("\\s");
        if (words.length != Consts.LEN_PARAM) {
            throw new InvalidScenarioException(
                    "Expected " + Consts.LEN_PARAM + " parameters, instead found: " + words.length);
        }
        try {
            Coordinates coordinates = getScenarioCoordinates(words);
            Flyable flyable = AircraftFactory.getInstance().newAircraft(
                    words[Consts.I_TYPE],
                    words[Consts.I_NAME],
                    coordinates);
            flyable.registerTower(tower);
        } catch (InvalidCoordinatesException e) {
            throw new InvalidScenarioException("Error in Scenario File: Invalid coordinates");
        } catch (UnsupportedFlyableException e) {
            throw new InvalidScenarioException("Error in Scenario File: Invalid Flyable name");
        }
    }

    private int getNumberOfSimulations(String line) throws InvalidNumberOfSimulations {
        try {
            int res = Integer.parseInt(line);
            if (res <= 0) {
                throw new InvalidNumberOfSimulations(
                        "Number of simulations must be a positive integer, instead found:|" + line + "|");
            }
            return res;
        } catch (NumberFormatException e) {
            throw new InvalidNumberOfSimulations("Expected a number, instead found:|" + line + "|", e);
        }
    }

    private Coordinates getScenarioCoordinates(String[] words) throws InvalidCoordinatesException {
        try {
            int longitude = Integer.parseInt(words[Consts.I_LONGITUDE]);
            int latitude = Integer.parseInt(words[Consts.I_LATITUDE]);
            int height = Integer.parseInt(words[Consts.I_HEIGHT]);
            return new Coordinates(longitude, latitude, height);
        } catch (NumberFormatException e) {
            throw new InvalidCoordinatesException("Coordinates must be positive Integers");
        }
    }
}
