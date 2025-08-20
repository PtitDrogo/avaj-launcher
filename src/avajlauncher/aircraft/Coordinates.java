package avajlauncher.aircraft;

public class Coordinates {
    private int longitude;
    private int latitute;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitute = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitute;
    }

    public int getHeight() {
        return height;
    }
}

// class Coordinates
// {
// -int longitude
// -int latitute
// -int height
// ~Coordinates(int p_longitude, int p_latitude, int p_height)
// +int getLongitude()
// +int getLatitude()
// +int getHeight()
// }