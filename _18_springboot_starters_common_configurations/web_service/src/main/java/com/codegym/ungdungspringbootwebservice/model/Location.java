package com.codegym.ungdungspringbootwebservice.model;

public class Location {
    private int id;
    private String nameLocation;
    private float temperature;
    private String weather;

    public Location() {
    }

    public Location(int id, String nameLocation, float temperature, String weather) {
        this.id = id;
        this.nameLocation = nameLocation;
        this.temperature = temperature;
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
