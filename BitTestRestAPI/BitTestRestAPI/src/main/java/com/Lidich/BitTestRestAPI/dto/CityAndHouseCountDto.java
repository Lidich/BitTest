package com.Lidich.BitTestRestAPI.dto;

import com.Lidich.BitTestRestAPI.entities.City;

public class CityAndHouseCountDto {
    private String cityName;
    private int houseCount;

    public CityAndHouseCountDto(City city, int houseCount){
        this.cityName = city.getName();
        this.houseCount = houseCount;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public String getCityName() {
        return cityName;
    }
}
