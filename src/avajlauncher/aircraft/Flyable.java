package avajlauncher.aircraft;

import java.io.IOException;
import avajlauncher.Writer;

import avajlauncher.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower WeatherTower;

    public abstract void updateConditions() throws IOException;

    public void registerTower(WeatherTower p_tower) throws IOException {
        WeatherTower = p_tower;
        WeatherTower.register(this);

        Writer writer = Writer.getInstance();
        writer.write("Registering to WeatherTower - " + getIDString() + " Safe Flight !");
    }

    public abstract String getIDString();

}

// +abstract void updateConditions()
// +registerTower(WeatherTower* p_tower)