package com.patrick_youri.android.mbd2_eetnu.models;

import java.io.Serializable;

/**
 * Created by Youri on 7-4-2015.
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -7060210544600464482L;
    private String street;
    private String zipcode;
    private String city;
    private String region;
    private String country;

    public Address(String street, String zipcode, String city, String region, String country) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
