package com.wtc.avaj.simulator;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

    }

    @Override
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                coordinates.update(5, 0, 0);
                Logger.getLogger().flyerLog(this, "as long as there are no cats and dogs falling well be fine");
                break;
            case "FOG":
                coordinates.update(1, 0, 0);
                Logger.getLogger().flyerLog(this, "I don't remember its all kind of foggy");
                break;
            case "SUN":
                coordinates.update(10, 0, 2);
                Logger.getLogger().flyerLog(this, "Sunny days");
                break;
            case "SNOW":
                coordinates.update(0, 0, -12);
                Logger.getLogger().flyerLog(this, "Ice chop");
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
    public String toString() {
        return "Helicopter#" + name + '(' + id +')';
    }
}
