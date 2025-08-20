package avajlauncher.aircraft;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate); //Kind of pointless, but its in the Diagram.
    }

    @Override
    public void updateConditions() {
        System.out.println("Helicopter is updating Conditions");
    }
}




// class Helicopter
// {
// +Helicopter(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }