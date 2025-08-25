package fortytwo.tfreydie.avajlauncher.aircraft;

import fortytwo.tfreydie.avajlauncher.Exceptions.InvalidCoordinatesException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) throws InvalidCoordinatesException {
        if (p_longitude < 0 || p_latitude < 0 || p_height < 0) {
            throw new InvalidCoordinatesException("Invalid coordinates: Coordinates must be positive integers");
        }
        p_height = Math.min(p_height, 100);
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
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