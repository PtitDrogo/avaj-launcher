package avajlauncher.aircraft;

import avajlauncher.Consts;

public class Jetplane extends Aircraft {
	public Jetplane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate); // Kind of pointless, but its in the Diagram.
	}

	@Override
	public void updateConditions() {
		String weather = WeatherTower.getWeather(coordinates);
		try {
			switch (weather) {
				case Consts.SUN:
					coordinates = new Coordinates(coordinates.getLongitude(),
							coordinates.getLatitude() + 10,
							coordinates.getHeight() + 2);
					System.out
							.println(Consts.JETPLANE + "#" + name + "(" + id + "): "
									+ "Time to spread some chemtrails !");
					break;
				case Consts.RAIN:
					coordinates = new Coordinates(coordinates.getLongitude(),
							coordinates.getLatitude() + 5,
							coordinates.getHeight());
					System.out.println(Consts.JETPLANE + "#" + name + "(" + id + "): "
							+ "Turbulences are when flying a plane becomes fun.");
					break;
				case Consts.FOG:
					coordinates = new Coordinates(coordinates.getLongitude(),
							coordinates.getLatitude() + 1,
							coordinates.getHeight());
					System.out.println(Consts.JETPLANE + "#" + name + "(" + id + "): "
							+ "Good thing I have this radar I don't see a thing !");
					break;
				case Consts.SNOW:
					coordinates = new Coordinates(coordinates.getLongitude(),
							coordinates.getLatitude(),
							coordinates.getHeight() - 7);
					System.out.println(Consts.JETPLANE + "#" + name + "(" + id + "): "
							+ "I love snow, in 50 years it will be all gone !");
					break;
				default:
					System.out.printf("Unsupported Weather\n");
			}
		} catch (Exception e) {
			WeatherTower.unregister(this);
			System.out.println(
					Consts.JETPLANE + "#" + name + "(" + id
							+ "): I am Landing ! Unregistering from WeatherTower");
		}
	}
}

// JetPlane:
// ◦ SUN - Latitude increases with 10, Height increases with 2
// ◦ RAIN - Latitude increases with 5
// ◦ FOG - Latitude increases with 1
// ◦ SNOW - Height decreases with 7

// class Jetplane
// {
// +Jetplane(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }