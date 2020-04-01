package com.example.deliveryshop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Delivery {

    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("city")
    @Expose
    private Object city;

    public Delivery(Object country, Object city) {
        this.country = country;
        this.city = city;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }
}
