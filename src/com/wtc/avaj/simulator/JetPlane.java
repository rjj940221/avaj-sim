package com.wtc.avaj.simulator;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);

    }

    @Override
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                coordinates.update(0, 5, 0);
                Logger.getLogger().flyerLog(this, "I feel a bit of a drip");
                break;
            case "FOG":
                coordinates.update(0, 1, 0);
                Logger.getLogger().flyerLog(this, "You can't see me");
                break;
            case "SUN":
                coordinates.update(0, 10, 2);
                Logger.getLogger().flyerLog(this, "Its a lovely sunny day if you look out to your right ...");
                break;
            case "SNOW":
                coordinates.update(0, 0, -7);
                Logger.getLogger().flyerLog(this, "Its freezing");
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
        return "JetPlain#" + name + '(' + id +')';
    }
}