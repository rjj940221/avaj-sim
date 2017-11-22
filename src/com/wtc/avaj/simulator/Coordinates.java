package com.wtc.avaj.simulator;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude(){
        return this.longitude;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public int getHeight(){
        return this.height;
    }

    void update(int deltaLongitude, int deltaLatitude, int deltaHeight){
        this.longitude += deltaLongitude;
        this.latitude += deltaLatitude;
        this.height += deltaHeight;
        if (height > 100)
            height = 100;
        if (height < 0)
            height = 0;
    }
}
