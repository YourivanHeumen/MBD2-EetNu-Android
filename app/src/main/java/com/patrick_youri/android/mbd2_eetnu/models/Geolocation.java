package com.patrick_youri.android.mbd2_eetnu.models;

import java.io.Serializable;

/**
 * Created by Youri on 7-4-2015.
 */
public class Geolocation implements Serializable {
    private static final long serialVersionUID = -7060210544600464483L;
    private double latitude;
    private double longitude;

    public Geolocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
