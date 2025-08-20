package avajlauncher.aircraft;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate); //Kind of pointless, but its in the Diagram.
    }

    @Override
    public void updateConditions() {
        System.out.println("Baloon is updating Conditions");
    }
}




// class Baloon
// {
// +Baloon(long p_id, string p_name, Coordinates p_coordinate)
// +void updateConditions()
// }
