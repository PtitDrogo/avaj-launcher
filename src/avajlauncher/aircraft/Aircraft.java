package avajlauncher.aircraft;


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
    public void updateConditions() {
        System.out.println("Generic aircraft updating conditions"); //This should never be triggered in theory.
    }
}


// class Aircraft
// {
// #long id
// #string name
// #Coordinate coordinates
// #Aircraft(long p_id, string p_name, Coordinates p_coordinate)
// }