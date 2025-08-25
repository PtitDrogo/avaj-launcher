package fortytwo.tfreydie.avajlauncher.tower;

import java.io.IOException;

import fortytwo.tfreydie.avajlauncher.aircraft.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() throws IOException {
        conditionChanged();
    }
    
}


/*
 * class WeatherTower
{
+string getWeather(Coordinates p_coordinates)
+void changeWeather()
}
 */