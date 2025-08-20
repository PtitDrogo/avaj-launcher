package avajlauncher.aircraft;

import avajlauncher.tower.WeatherProvider;

public class Baloon extends Aircraft {    
    
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate); //Kind of pointless, but its in the Diagram.
    }

    @Override
    public void updateConditions() {
        System.out.println("Baloon is updating Conditions");
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        switch (weather) {
                case "SUN":
                    System.out.printf("Created aircraft of type |%s| with id %d\n", p_type, id);
                case "helicopter":
                    System.out.printf("Created aircraft of type |%s| with id %d\n", p_type, id);
                case "jetplane":
                    System.out.printf("Created aircraft of type |%s| with id %d\n", p_type, id);
                case "jetplane":
                    System.out.printf("Created aircraft of type |%s| with id %d\n", p_type, id);
                default:
                    System.out.printf("Could not create an Aircraft, the type : |%s| is not supported.", p_type);
            }
    }
}




// class Baloon
// {
// +Baloon(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }

/*
 * • Baloon:
◦ SUN - Longitude increases with 2, Height increases with 4
◦ RAIN - Height decreases with 5
◦ FOG - Height decreases with 3
◦ SNOW - Height decreases with 15
 */