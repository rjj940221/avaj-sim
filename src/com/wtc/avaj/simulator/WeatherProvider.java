package com.wtc.avaj.simulator;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null)
        {
            synchronized (WeatherProvider.class) {
                weatherProvider = new WeatherProvider();
            }
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return weather[(int)(Math.random() * 4)];
    }
}
