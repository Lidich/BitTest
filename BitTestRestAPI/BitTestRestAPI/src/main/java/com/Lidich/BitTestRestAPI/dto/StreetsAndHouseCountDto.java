package com.Lidich.BitTestRestAPI.dto;

public class StreetsAndHouseCountDto {
    private String streetName;
    private int houseCount;

    public StreetsAndHouseCountDto(String streetName, int houseCount){
        this.houseCount = houseCount;
        this.streetName = streetName;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public String getStreetName() {
        return streetName;
    }
}
