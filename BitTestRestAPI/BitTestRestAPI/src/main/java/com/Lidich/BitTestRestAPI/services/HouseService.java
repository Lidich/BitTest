package com.Lidich.BitTestRestAPI.services;

import com.Lidich.BitTestRestAPI.dto.HouseWithAddressAndApartmentCountDto;
import com.Lidich.BitTestRestAPI.entities.City;
import com.Lidich.BitTestRestAPI.entities.House;
import com.Lidich.BitTestRestAPI.entities.Street;
import com.Lidich.BitTestRestAPI.exeptions.EntityNotFoundException;
import com.Lidich.BitTestRestAPI.repositories.ApartmentRepository;
import com.Lidich.BitTestRestAPI.repositories.CityRepository;
import com.Lidich.BitTestRestAPI.repositories.HouseRepository;
import com.Lidich.BitTestRestAPI.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private final ApartmentRepository apartmentRepository;
    private final CityRepository cityRepository;
    private final HouseRepository houseRepository;
    private final StreetRepository streetRepository;

    @Autowired
    public HouseService(ApartmentRepository apartmentRepository,
                       CityRepository cityRepository,
                       HouseRepository houseRepository,
                       StreetRepository streetRepository){
        this.apartmentRepository = apartmentRepository;
        this.cityRepository = cityRepository;
        this.houseRepository = houseRepository;
        this.streetRepository = streetRepository;
    }

    public List<HouseWithAddressAndApartmentCountDto> getHousesWithAddressByCity(Long city_id){
        City city = cityRepository.findById(city_id).orElseThrow(EntityNotFoundException::new);
        List<HouseWithAddressAndApartmentCountDto> houseWithAddressAndApartmentCountDtoList = new ArrayList<>();
        List<Street> streetList = city.getStreetList();
        for(Street street: streetList){
            List<House> houseList = street.getHouseList();
            for(House house: houseList){
                int count = house.getApartmentList().size();
                houseWithAddressAndApartmentCountDtoList.add(new HouseWithAddressAndApartmentCountDto(house.getNumber(), count, city.getName(), street.getName()));
            }
        }
        return (houseWithAddressAndApartmentCountDtoList);
    }

    public List<HouseWithAddressAndApartmentCountDto> getHousesWithAdressByStreet(Long street_id){
        Street street = streetRepository.findById(street_id).orElseThrow(EntityNotFoundException::new);
        City city = street.getCity();
        List<HouseWithAddressAndApartmentCountDto> houseWithAddressAndApartmentCountDtoList = new ArrayList<>();
        List<House> houseList = street.getHouseList();
        for(House house: houseList){
            int count = house.getApartmentList().size();
            houseWithAddressAndApartmentCountDtoList.add(new HouseWithAddressAndApartmentCountDto(house.getNumber(), count, city.getName(), street.getName()));
        }
        return (houseWithAddressAndApartmentCountDtoList);
    }

    public Long findHouseByAddress(String address){
        String cityName = null;
        String streetName = null;
        String houseNumber = null;

        String[] parts = address.split("[\\s,.;:]+");
        for(int i=0;i<parts.length;i++){
            String tempPart = parts[i];
            if(tempPart.equals("city")&& (i!=parts.length-1)) cityName=parts[i+1];
            if(tempPart.equals("street")&& (i!=parts.length-1)) streetName=parts[i+1];
            if(tempPart.equals("house") && (i!=parts.length-1)) houseNumber=parts[i+1];
        }
        City city = cityRepository.findCityByNameIgnoreCase(cityName);
        if(city==null) throw new EntityNotFoundException();
        Street street = streetRepository.findStreetByCity_IdAndNameIgnoreCase(city.getId(), streetName);
        if(street==null) throw new EntityNotFoundException();
        House house = houseRepository.findHouseByStreet_IdAndNumber(street.getId(), houseNumber);
        if(house!=null) return house.getId();
        else throw new EntityNotFoundException();
    }
}
