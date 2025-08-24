package avajlauncher.aircraft;

import avajlauncher.Consts;
import avajlauncher.Exceptions.UnsupportedFlyableException;

public class AircraftFactory {
        static private long id = 0;

        //Singleton - Lazy init
        private static AircraftFactory instance = null;
        private AircraftFactory(){};

        public static AircraftFactory getInstance() {
            if (instance == null) {
                instance = new AircraftFactory();
                return instance;
            }
            return instance;
        }

        public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws UnsupportedFlyableException {
            id++;
            String AircraftType = p_type.toUpperCase();         

            switch (AircraftType) {
                case Consts.BALOON:
                    System.out.printf("Created aircraft of type |%s| with id %d\n", p_type, id);
                    return new Baloon(id, p_name, p_coordinates);
                case Consts.HELICOPTER:
                    System.out.printf("Created aircraft of type |%s| with id %d\n", p_type, id);
                    return new Helicopter(id, p_name, p_coordinates);
                case Consts.JETPLANE:
                    System.out.printf("Created aircraft of type |%s| with id %d\n", p_type, id);
                    return new Jetplane(id, p_name, p_coordinates);
                default:
                    throw new UnsupportedFlyableException("Could not create an Aircraft, the type:|" + p_type + "| is not supported.");
            }
        }




}


// class AircraftFactory <<Singleton>>
// {
// +Flyable* newAircraft(string p_type, string p_name, Coordinates p_coordinates)
// }

