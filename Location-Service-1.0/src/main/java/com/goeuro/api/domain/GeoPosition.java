package com.goeuro.api.domain;

import java.io.Serializable;

/**
 * Created by wamalalawrence on 15/11/04.
 * GeoPosition model object
 */

public class GeoPosition implements Serializable{

    private double latitude;
    private double longitude;

    //getter and setter methods
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "GeoPosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
