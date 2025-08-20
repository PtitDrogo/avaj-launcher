package avajlauncher;

import avajlauncher.scenarioParser.ScenarioParser;
import avajlauncher.aircraft.AircraftFactory;


public class Main {

    public static void main(String[] args) {
        if (new ScenarioParser().isValidScenario(args) == false) {
            return;
        }

        AircraftFactory factory = AircraftFactory.getInstance();
        factory = AircraftFactory.getInstance(); 

        //Now I want to have a loop that will iterate over my Line and creates the aircrafts
        //I can assume my file has valid format in term of number of words and numbers.



        

        //Implementation of Class
    } 
}




