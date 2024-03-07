package com.Lidich.BitTestRestAPI.dto;

public class HouseWithAddressAndApartmentCountDto {
    private String houseNumber;
    private int apartmentCount;
    private String cityName;
    private String streetName;

    public HouseWithAddressAndApartmentCountDto(String houseNumber, int apartmentCount, String cityName, String streetName){
        this.apartmentCount = apartmentCount;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public int getApartmentCount() {
        return apartmentCount;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}
