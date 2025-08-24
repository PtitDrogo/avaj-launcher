package avajlauncher;

import avajlauncher.aircraft.ScenarioParser;
import avajlauncher.tower.WeatherTower;
import avajlauncher.Exceptions.InvalidScenarioException;


public class Main {

    public static void main(String[] args) {
        WeatherTower tower = new WeatherTower();

        try {
            int numberSimulations = new ScenarioParser().processScenario(args, tower);
            for (int i = 0; i < numberSimulations; i++) {
                tower.changeWeather();
            }
        } catch (InvalidScenarioException e) {
            System.out.println("Error while reading the scenario file: " + e.getMessage());
            System.out.println("CAUSE:" + e.getCause());
            System.out.println("Exiting ...");
        }

    } 
}




