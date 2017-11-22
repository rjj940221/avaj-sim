package com.wtc.avaj.simulator;

import com.wtc.avaj.simulator.tower.Tower;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        super.conditionsChange();
    }
}
