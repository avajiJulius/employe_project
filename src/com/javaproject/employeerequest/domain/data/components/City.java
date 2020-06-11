package com.javaproject.employeerequest.domain.data.components;

public class City {
    private long cityId;
    private String cityName;

    public City(long cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City() {
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
