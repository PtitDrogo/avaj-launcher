package fortytwo.tfreydie.avajlauncher;

import fortytwo.tfreydie.avajlauncher.aircraft.ScenarioParser;
import fortytwo.tfreydie.avajlauncher.tower.WeatherTower;

import java.io.File;
import java.io.IOException;

import fortytwo.tfreydie.avajlauncher.Exceptions.InvalidScenarioException;

public class Simulation {
    public static void main(String[] args) {
        WeatherTower tower = new WeatherTower();

        try {
            int numberSimulations = new ScenarioParser().processScenario(args, tower);
            for (int i = 0; i < numberSimulations; i++) {
                tower.changeWeather();
            }
            Writer.getInstance().close();
        } catch (InvalidScenarioException e) {
            System.out.println("Error while reading the scenario file: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("CAUSE:" + e.getCause());
            }
            errorCleanUp();
            return;
        } catch (IOException e) {
            System.out.println("Error while writing the simulation file: " + e.getMessage());
            errorCleanUp();
            return;
        } catch (Exception e) {
            System.out.println("Unknown Error: " + e.getMessage());
            errorCleanUp();
            return;
        }
        System.out.println("Simulation ran successfully !");
    }

    static public void errorCleanUp() {
        try {
            Writer.getInstance().close();
        } catch (Exception test) {
        }
        new File(Consts.FILE_NAME).delete();
        System.out.println("Exiting ...");
    }
}
