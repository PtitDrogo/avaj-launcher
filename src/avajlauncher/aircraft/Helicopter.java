package avajlauncher.aircraft;

import java.io.IOException;

import avajlauncher.Consts;
import avajlauncher.Exceptions.InvalidCoordinatesException;
import avajlauncher.Writer;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
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
                            coordinates.getLongitude() + 10,
                            coordinates.getLatitude(),
                            coordinates.getHeight() + 2);
                    writer.write(Consts.HELICOPTER + "#" + name + "(" + id + "): "
                            + "I love the smell of napalm in the morning");
                    break;
                case Consts.RAIN:
                    coordinates = new Coordinates(
                            coordinates.getLongitude() + 5,
                            coordinates.getLatitude(),
                            coordinates.getHeight());
                    writer.write(Consts.HELICOPTER + "#" + name + "(" + id + "): "
                            + "This rain better not get in the electronics");
                    break;
                case Consts.FOG:
                    coordinates = new Coordinates(
                            coordinates.getLongitude() + 1,
                            coordinates.getLatitude(),
                            coordinates.getHeight());
                    writer.write(Consts.HELICOPTER + "#" + name + "(" + id + "): " + "Good thing I am a mistborn");
                    break;
                case Consts.SNOW:
                    coordinates = new Coordinates(
                            coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 12);
                    writer.write(Consts.HELICOPTER + "#" + name + "(" + id + "): "
                            + "I don't rotate as fast because of this snow");
                    break;
                default:
                    System.out.printf("Unsupported Weather\n");
                    break;
            }
        } catch (InvalidCoordinatesException e) {
            WeatherTower.unregister(this);
            writer.write(
                    Consts.HELICOPTER + "#" + name + "(" + id + "): I am Landing ! Unregistering from WeatherTower");
        }
    }
}

// class Helicopter
// {
// +Helicopter(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }