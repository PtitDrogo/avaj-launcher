package avajlauncher.aircraft;

import java.io.IOException;

import avajlauncher.Consts;
import avajlauncher.Writer;
import avajlauncher.Exceptions.InvalidCoordinatesException;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() throws IOException {
        String weather = WeatherTower.getWeather(coordinates);
        Writer writer = Writer.getInstance();
        try {
            switch (weather) {
                case Consts.SUN:
                    coordinates = new Coordinates(
                            coordinates.getLongitude() + 2,
                            coordinates.getLatitude(),
                            coordinates.getHeight() + 4);
                    writer.write(getIDString() + "In the sun just chilling !");
                    break;
                case Consts.RAIN:
                    coordinates = new Coordinates(
                            coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 5);
                    System.out
                            .println(getIDString() + "Rain on my baloon, kinda cozy.");
                    break;
                case Consts.FOG:
                    coordinates = new Coordinates(
                            coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 3);
                    writer.write(getIDString() + "With this fog a bird could pierce my baloon with its beak, scary.");
                    break;
                case Consts.SNOW:
                    coordinates = new Coordinates(
                            coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 15);
                    writer.write(getIDString() + "This snow is making me go down, Curses !");
                    break;
                default:
                    System.out.printf("Unsupported Weather\n");
                    break;
            }
        } catch (InvalidCoordinatesException e) {
            WeatherTower.unregister(this);
            writer.write(getIDString() + "I am Landing Slowly ! Unregistering from WeatherTower");
        }
    }

    @Override
    public String getIDString() {
        return Consts.BALOON + "#" + name + "(" + id + "): ";        
    }

}

// class Baloon
// {
// +Baloon(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }