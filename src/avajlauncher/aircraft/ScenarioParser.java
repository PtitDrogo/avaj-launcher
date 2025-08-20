package avajlauncher.aircraft;

import java.io.BufferedReader;
import java.io.FileReader;

import avajlauncher.Consts;
import avajlauncher.tower.Tower;

public class ScenarioParser {
    public Boolean isValidScenario(String[] args, Tower tower) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments. Exiting ...");
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
                if (!validateLine(line, tower)) {
                    reader.close();
                    return false;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error while reading the scenario file: " + e.getMessage() + " Exiting ...");
            return false;
        }
        return true;
    }


    private Boolean validateLine(String line, Tower tower) {
        System.out.printf("Validating the line: |%s| \n", line);
        String[] words = line.split("\\s");
        if (words.length != Consts.LEN_PARAM) {
            System.out.printf("Expected %d parameters, instead found: |%s|\n", Consts.LEN_PARAM, line);
            return false;
        }
        for (int i = Consts.I_LONGITUDE; i <= Consts.I_LATITUDE; i++) {
            if (!isValidCoordinate(words[i])) {
                return false;
            }
        }
        if (!isValidHeight(words[Consts.I_HEIGHT])) {
            return false;
        }
        

        //We build our aircraft + add it to towers
        //Below line is too long :D
        Coordinates coordinates = new Coordinates(Integer.parseInt(words[Consts.I_LONGITUDE]),Integer.parseInt(words[Consts.I_LATITUDE]), Integer.parseInt(words[Consts.I_HEIGHT]));
        Flyable flyable = AircraftFactory.getInstance().newAircraft(words[Consts.I_TYPE], words[Consts.I_NAME], coordinates);
        tower.register(flyable);
        System.out.println("Adding Flyable to our tower : " + words[Consts.I_TYPE]);


        return true;
    }

    private Boolean isValidHeight(String HeightStr) {
        try {
            int height = Integer.parseInt(HeightStr);
            Boolean res = height >= 0 && height <= 100;
            if (res == false) {
                System.out.printf("Altitude must be between 0 and 100, instead found: |%d|\n", height);
            }
            return res;
        } catch (NumberFormatException e) {
            System.out.printf("Expected a number, instead found: |%s|\n", HeightStr);
            return false;
        }
    }

    private Boolean isValidCoordinate(String CoordinateStr) {
        try {
            int coordinate = Integer.parseInt(CoordinateStr);
            Boolean res = coordinate >= 0;
            if (res == false) {
                System.out.printf("Coordinate must be a positive number, instead found: |%d|\n", coordinate);
            }
            return res;
        } catch (NumberFormatException e) {
            System.out.printf("Expected a number, instead found: |%s|\n", CoordinateStr);
            return false;
        }
    }

    private Boolean isValidFirstLine(String line) {
        String[] words = line.split("\\s");
        if (words.length != 1) {
            System.out.printf("Expected a number, instead found: |%s|\n", line);
            return false;
        }
        if (!isInteger(words[0])) {
            System.out.printf("Expected a number, instead found: |%s|\n", line);
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
