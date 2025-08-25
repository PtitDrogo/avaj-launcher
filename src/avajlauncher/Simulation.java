package avajlauncher;

import avajlauncher.aircraft.ScenarioParser;
import avajlauncher.tower.WeatherTower;
import java.io.IOException;

import avajlauncher.Exceptions.InvalidScenarioException;

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
            System.out.println("CAUSE:" + e.getCause());
            System.out.println("Exiting ...");
        } catch (IOException e) {
            System.out.println("Error while writing the simulation file: " + e.getMessage());
        }
    }
}



    // static BufferedWriter writer;
