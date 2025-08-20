package avajlauncher.aircraft;

import avajlauncher.Consts;
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
                case Consts.SUN:
                    coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                    System.out.println(Consts.BALOON + "#" + name + "(" + id + "): " + "In the sun just chilling !");
                case Consts.RAIN:
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                    System.out.println(Consts.BALOON + "#" + name + "(" + id + "): " + "Rain on my baloon, kinda cozy.");
                case Consts.FOG:
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                    System.out.println(Consts.BALOON + "#" + name + "(" + id + "): " + "With this fog a bird could pierce my baloon with its beak, scary.");
                case Consts.SNOW:
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                    System.out.println(Consts.BALOON + "#" + name + "(" + id + "): " + "This snow is making me go down, Curses !");
                default:
                    System.out.printf("Unsupported Weather\n");
            }
        if (coordinates.getHeight() == 0) {
            System.out.printf("");
        }
    }
}

//TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE.


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