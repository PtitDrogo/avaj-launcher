package avajlauncher.aircraft;

import avajlauncher.Consts;

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

        public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
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
                    //BONUS: This will be an exception that exits our programm later
                    System.out.printf("Could not create an Aircraft, the type : |%s| is not supported.", p_type);
                    return null;
            }
        }




}


// class AircraftFactory <<Singleton>>
// {
// +Flyable* newAircraft(string p_type, string p_name, Coordinates p_coordinates)
// }

