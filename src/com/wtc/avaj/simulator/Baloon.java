package com.wtc.avaj.simulator;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);

    }

    @Override
    public void updateConditions(){

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
