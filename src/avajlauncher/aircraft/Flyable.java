package avajlauncher.aircraft;

import avajlauncher.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower WeatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        WeatherTower = p_tower;
        WeatherTower.register(this);
    }
    
}

// +abstract void updateConditions()
// +registerTower(WeatherTower* p_tower)