package avajlauncher.aircraft;

import java.io.IOException;

import avajlauncher.Consts;
import avajlauncher.Writer;
import avajlauncher.Exceptions.InvalidCoordinatesException;

public class Jetplane extends Aircraft {
	public Jetplane(long p_id, String p_name, Coordinates p_coordinate) {
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
							coordinates.getLongitude(),
							coordinates.getLatitude() + 10,
							coordinates.getHeight() + 2);
					writer.write(Consts.JETPLANE + "#" + name + "(" + id + "): "
							+ "Time to spread some chemtrails !");
					break;
				case Consts.RAIN:
					coordinates = new Coordinates(
							coordinates.getLongitude(),
							coordinates.getLatitude() + 5,
							coordinates.getHeight());
					writer.write(Consts.JETPLANE + "#" + name + "(" + id + "): "
							+ "Turbulences are when flying a plane becomes fun.");
					break;
				case Consts.FOG:
					coordinates = new Coordinates(
							coordinates.getLongitude(),
							coordinates.getLatitude() + 1,
							coordinates.getHeight());
					writer.write(Consts.JETPLANE + "#" + name + "(" + id + "): "
							+ "Good thing I have this radar I don't see a thing !");
					break;
				case Consts.SNOW:
					coordinates = new Coordinates(
							coordinates.getLongitude(),
							coordinates.getLatitude(),
							coordinates.getHeight() - 7);
					writer.write(Consts.JETPLANE + "#" + name + "(" + id + "): "
							+ "I love snow, in 50 years it will be all gone !");
					break;
				default:
					System.out.printf("Unsupported Weather\n");
			}
		} catch (InvalidCoordinatesException e) {
			WeatherTower.unregister(this);
			writer.write(Consts.JETPLANE + "#" + name + "(" + id + "): I am Landing ! Unregistering from WeatherTower");
		}
	}
}

// class Jetplane
// {
// +Jetplane(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }