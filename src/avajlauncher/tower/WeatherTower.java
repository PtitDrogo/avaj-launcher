package avajlauncher.tower;

import avajlauncher.aircraft.Coordinates;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates p_coordinates) {
        return "Its sunny bro";
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