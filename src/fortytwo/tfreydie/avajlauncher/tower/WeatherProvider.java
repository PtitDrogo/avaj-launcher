package fortytwo.tfreydie.avajlauncher.tower;

import java.util.Random;

import fortytwo.tfreydie.avajlauncher.Consts;
import fortytwo.tfreydie.avajlauncher.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider instance = null;

    private WeatherProvider() {
    };

    private String[] weather = {
            Consts.RAIN,
            Consts.FOG,
            Consts.SUN,
            Consts.SNOW,
    };

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int value = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        int Turbulences = new Random().nextInt(100) + 1;
        return weather[(value * Turbulences) % 4];
    }

}

/*
 * class WeatherProvider <<Singleton>>
 * {
 * -string[] weather
 * -WeatherProvider()
 * +string getCurrentWeather(Coordinates p_coordinates)
 * }
 */