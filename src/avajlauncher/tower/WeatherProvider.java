package avajlauncher.tower;

import avajlauncher.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider instance = null;

    private WeatherProvider() {
    };

    private String[] weather = {
            "RAIN",
            "FOG",
            "SUN",
            "SNOW",
    };

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
            return instance;
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int value = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        return weather[value % 4];
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