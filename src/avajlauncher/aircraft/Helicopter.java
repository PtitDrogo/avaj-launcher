package avajlauncher.aircraft;

import avajlauncher.Consts;
import avajlauncher.tower.WeatherProvider;
import avajlauncher.tower.WeatherTower;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate); // Kind of pointless, but its in the Diagram.
    }

    @Override
    public void updateConditions() {
        System.out.println("Helicopter is updating Conditions");
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates); // This should be the get weather
                                                                                       // of our tower.
        switch (weather) {
            case Consts.SUN:
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(),
                        coordinates.getHeight() + 2);
                System.out.println(Consts.HELICOPTER + "#" + name + "(" + id + "): "
                        + "I love the smell of napalm in the morning");
            case Consts.RAIN:
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                        coordinates.getHeight());
                System.out.println(Consts.HELICOPTER + "#" + name + "(" + id + "): "
                        + "This rain better not get in the electronics");
            case Consts.FOG:
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                        coordinates.getHeight());
                System.out.println(Consts.HELICOPTER + "#" + name + "(" + id + "): " + "Good thing I am a mistborn");
            case Consts.SNOW:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 12);
                System.out.println(Consts.HELICOPTER + "#" + name + "(" + id + "): "
                        + "I don't rotate as fast because of this snow");
            default:
                System.out.printf("Unsupported Weather\n");
        }
        if (coordinates.getHeight() == 0) {
            WeatherTower.unregister(this);
            System.out.println(
                    Consts.HELICOPTER + "#" + name + "(" + id + "): I am Landing ! Unregistering from WeatherTower");
        }
    }
}

/*
 * SUN - Longitude increases with 10, Height increases with 2
 * ◦ RAIN - Longitude increases with 5
 * ◦ FOG - Longitude increases with 1
 * ◦ SNOW - Height decreases with 12
 */

// class Helicopter
// {
// +Helicopter(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }