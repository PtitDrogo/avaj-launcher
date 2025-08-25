package fortytwo.tfreydie.avajlauncher.aircraft;

import java.io.IOException;

import fortytwo.tfreydie.avajlauncher.Consts;
import fortytwo.tfreydie.avajlauncher.Writer;
import fortytwo.tfreydie.avajlauncher.Exceptions.InvalidCoordinatesException;

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
					writer.write(getIDString() + "Time to spread some chemtrails !");
					break;
				case Consts.RAIN:
					coordinates = new Coordinates(
							coordinates.getLongitude(),
							coordinates.getLatitude() + 5,
							coordinates.getHeight());
					writer.write(getIDString() + "Turbulences are when flying a plane becomes fun.");
					break;
				case Consts.FOG:
					coordinates = new Coordinates(
							coordinates.getLongitude(),
							coordinates.getLatitude() + 1,
							coordinates.getHeight());
					writer.write(getIDString() + "Good thing I have this radar I don't see a thing !");
					break;
				case Consts.SNOW:
					coordinates = new Coordinates(
							coordinates.getLongitude(),
							coordinates.getLatitude(),
							coordinates.getHeight() - 7);
					writer.write(getIDString() + "I love snow, in 50 years it will be all gone !");
					break;
				default:
					System.out.printf("Unsupported Weather\n");
			}
		} catch (InvalidCoordinatesException e) {
			WeatherTower.unregister(this);
			writer.write(getIDString() + "I am Landing and this time I won't crash ! Unregistering from WeatherTower");
		}
	}

	@Override
	public String getIDString() {
		return Consts.JETPLANE + "#" + name + "(" + id + "): ";
	}
}

// class Jetplane
// {
// +Jetplane(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }