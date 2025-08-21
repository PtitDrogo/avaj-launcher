package avajlauncher.aircraft;

import avajlauncher.Consts;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate); // Kind of pointless, but its in the Diagram.
    }

    @Override
    public void updateConditions() {
        String weather = WeatherTower.getWeather(coordinates);
        try {
            switch (weather) {
                case Consts.SUN:
                    coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(),
                            coordinates.getHeight() + 4);
                    System.out.println(Consts.BALOON + "#" + name + "(" + id + "): " + "In the sun just chilling !");
                    break;
                case Consts.RAIN:
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                            coordinates.getHeight() - 5);
                    System.out
                            .println(Consts.BALOON + "#" + name + "(" + id + "): " + "Rain on my baloon, kinda cozy.");
                    break;
                case Consts.FOG:
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                            coordinates.getHeight() - 3);
                    System.out.println(Consts.BALOON + "#" + name + "(" + id + "): "
                            + "With this fog a bird could pierce my baloon with its beak, scary.");
                    break;
                case Consts.SNOW:
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                            coordinates.getHeight() - 15);
                    System.out.println(
                            Consts.BALOON + "#" + name + "(" + id + "): " + "This snow is making me go down, Curses !");
                    break;
                default:
                    System.out.printf("Unsupported Weather\n");
                    break;
            }
        } catch (Exception e) {
            WeatherTower.unregister(this);
            System.out.println(
                    Consts.BALOON + "#" + name + "(" + id + "): I am Landing ! Unregistering from WeatherTower");
        }
    }
}

// TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE.

// class Baloon
// {
// +Baloon(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }

/*
 * • Baloon:
 * ◦ SUN - Longitude increases with 2, Height increases with 4
 * ◦ RAIN - Height decreases with 5
 * ◦ FOG - Height decreases with 3
 * ◦ SNOW - Height decreases with 15
 */