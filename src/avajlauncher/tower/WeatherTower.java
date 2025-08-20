package avajlauncher.tower;

import avajlauncher.aircraft.Coordinates;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates); //I mean what else could it be
    }

    public void changeWeather() {
        System.out.println("Changing the weather !");
    }
    
}


/*
 * class WeatherTower
{
+string getWeather(Coordinates p_coordinates)
+void changeWeather()
}
 */