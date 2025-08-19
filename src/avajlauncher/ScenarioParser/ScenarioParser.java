package avajlauncher.ScenarioParser;

import java.io.BufferedReader;
import java.io.FileReader;

public class ScenarioParser {
    public static Boolean validateScenario(String[] args) {
        System.out.println(args.length);
        if (args.length != 1) {
            System.out.println("Invalid number of arguments, exiting ...");
            return false;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                validateLine(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();// Probably just exit the system
            System.out.println("Error while reading the scenario file, Exiting ...");
            return false;
        }
        return true;
    }

    private static Boolean validateLine(String line) {
        System.out.println("Validating stuff bzz bzz");
        return true;
    }
}

