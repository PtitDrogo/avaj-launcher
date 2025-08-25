package fortytwo.tfreydie.avajlauncher.aircraft;

import java.io.IOException;

public class Aircraft extends Flyable {
    protected Long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinate;
    }

    @Override
    public void updateConditions() throws IOException {
        // Necessary because UML wants Aircraft to be a concrete class
    }

    @Override
    public String getIDString() {
        return "Unspecified Aircraft";
    }

    // Baloon#B1(1)

}

// class Aircraft
// {
// #long id
// #string name
// #Coordinate coordinates
// #Aircraft(long p_id, string p_name, Coordinates p_coordinate)
// }