package fortytwo.tfreydie.avajlauncher.aircraft;

import fortytwo.tfreydie.avajlauncher.Consts;
import fortytwo.tfreydie.avajlauncher.Exceptions.UnsupportedFlyableException;

public class AircraftFactory {
    static private long id = 0;

    private static AircraftFactory instance = null;

    private AircraftFactory() {
    };

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
            throws UnsupportedFlyableException {
        id++;
        String AircraftType = p_type.toUpperCase();

        switch (AircraftType) {
            case Consts.BALOON:
                return new Baloon(id, p_name, p_coordinates);
            case Consts.HELICOPTER:
                return new Helicopter(id, p_name, p_coordinates);
            case Consts.JETPLANE:
                return new Jetplane(id, p_name, p_coordinates);
            default:
                throw new UnsupportedFlyableException(
                        "Could not create an Aircraft, the type:|" + p_type + "| is not supported.");
        }
    }

}

// class AircraftFactory <<Singleton>>
// {
// +Flyable* newAircraft(string p_type, string p_name, Coordinates
// p_coordinates)
// }
