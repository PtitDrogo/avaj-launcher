package avajlauncher.ScenarioParser;

import java.io.BufferedReader;
import java.io.FileReader;

public class ScenarioParser {
    public Boolean isValidScenario(String[] args) {
        if (args.length != 1) {
            System.err.println("Invalid number of arguments. Exiting ...");
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (!isValidFirstLine(line)) {
                reader.close();
                return false;
            }
            while ((line = reader.readLine()) != null) {
                if (!validateLine(line)) {
                    reader.close();
                    return false;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error while reading the scenario file: " + e.getMessage() + " Exiting ...");
            return false;
        }
        return true;
    }

    private Boolean validateLine(String line) {
        System.out.printf("Validating the line: |%s| \n", line);
        String[] words = line.split("\\s");
        if (words.length != 5) {
            System.err.printf("Expected 5 parameters, instead found: |%s|\n", line);
            return false;
        }
        if (!isValidHeight(words[2])) {
            return false;
        }
        for (int i = 3; i < 5; i++) {
            if (!isValidCoordinate(words[i])) {
                return false;
            }
        }
        return true;
    }

    private Boolean isValidHeight(String HeightStr) {
        try {
            int height = Integer.parseInt(HeightStr);
            Boolean res = height >= 0 && height <= 100;
            if (res == false) {
                System.err.printf("Altitude must be between 0 and 100, instead found: |%d|\n", height);
            }
            return res;
        } catch (NumberFormatException e) {
            System.err.printf("Expected a number, instead found: |%s|\n", HeightStr);
            return false;
        }
    }

    private Boolean isValidCoordinate(String CoordinateStr) {
        try {
            int coordinate = Integer.parseInt(CoordinateStr);
            Boolean res = coordinate >= 0;
            if (res == false) {
                System.err.printf("Coordinate must be a positive number, instead found: |%d|\n", coordinate);
            }
            return res;
        } catch (NumberFormatException e) {
            System.err.printf("Expected a number, instead found: |%s|\n", CoordinateStr);
            return false;
        }
    }

    private Boolean isValidFirstLine(String line) {
        String[] words = line.split("\\s");
        if (words.length != 1) {
            System.err.printf("Expected a number, instead found: |%s|\n", line);
            return false;
        }
        if (!isInteger(words[0])) {
            System.err.printf("Expected a number, instead found: |%s|\n", line);
            return false;
        }
        return true;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
