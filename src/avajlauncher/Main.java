package avajlauncher;

import avajlauncher.ScenarioParser.ScenarioParser;
import avajlauncher.test.Hello;

public class Main {

    public static void main(String[] args) {
        Hello.hello();

        if (ScenarioParser.validateScenario(args) == false) {
            return;
        }
        


        
        //Implementation of Class
    } 
}
