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
        int idx = 0;
        if (coordinates.getHeight() > 70) {
            if ((int) (Math.random() * 4) == 1)
                idx = 3;
            else
                idx = (int) (Math.random() * 4);
        }
        else if(coordinates.getHeight() > 50) {
            if ((int) (Math.random() * 2) == 1)
                idx = 3;
            else
                idx = (int) (Math.random() * 4);
        }
        else
            idx = (int) (Math.random() * 4);
        return weather[idx];
    }
}
