package avajlauncher.aircraft;

public class Coordinates {
    private int _longitude;
    private int _latitute;
    private int _height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        _longitude = p_longitude;
        _latitute = p_latitude;
        _height = p_height;
    }

    public int getLongitude() {
        return _longitude;
    }

    public int getLatitude() {
        return _latitute;
    }

    public int getHeight() {
        return _height;
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