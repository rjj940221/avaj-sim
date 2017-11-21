package com.wtc.avaj.simulator;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String weather[];

    private WeatherProvider(){

    }

    private static WeatherProvider getProvider(){
        if (weatherProvider == null)
        {
            synchronized (WeatherProvider.class) {
                weatherProvider = new WeatherProvider();
            }
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return "";
    }
}
