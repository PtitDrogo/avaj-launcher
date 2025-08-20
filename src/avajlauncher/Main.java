package avajlauncher;

import avajlauncher.aircraft.ScenarioParser;
import avajlauncher.tower.WeatherTower;



public class Main {

    public static void main(String[] args) {
        WeatherTower tower = new WeatherTower();

        if (new ScenarioParser().isValidScenario(args, tower) == false) {
            return;
        }

        //Now I want to have a loop that will iterate over my Line and creates the aircrafts
        //I can assume my file has valid format in term of number of words and numbers.
    } 
}




