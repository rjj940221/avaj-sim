package com.wtc.avaj.simulator;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);

    }

    @Override
    public void updateConditions(){

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}