package com.wtc.avaj.simulator;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);

    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                coordinates.update(0, 0, -5);
                Logger.getLogger().flyerLog(this, "Tis raining, tis pouring");
                break;
            case "FOG":
                coordinates.update(0, 0, -3);
                Logger.getLogger().flyerLog(this, "I dont remember its all kind of foggy");
                break;
            case "SUN":
                coordinates.update(2, 0, 4);
                Logger.getLogger().flyerLog(this, "its to hot to be round a fire");
                break;
            case "SNOW":
                coordinates.update(0, 0, -15);
                Logger.getLogger().flyerLog(this, "Let it snow let it snow");
                break;
        }
        if (coordinates.getHeight() == 0) {
            Logger.getLogger().flyerLog(this, "landing " + coordinates.getLongitude() + ' ' + coordinates.getLatitude());
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public String toString(){
        return "Baloon#" + name + '(' + id +')';
    }
}
