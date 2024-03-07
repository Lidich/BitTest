package com.Lidich.BitTestRestAPI.services;

import com.Lidich.BitTestRestAPI.dto.CityAndHouseCountDto;
import com.Lidich.BitTestRestAPI.entities.City;
import com.Lidich.BitTestRestAPI.entities.Street;
import com.Lidich.BitTestRestAPI.repositories.ApartmentRepository;
import com.Lidich.BitTestRestAPI.repositories.CityRepository;
import com.Lidich.BitTestRestAPI.repositories.HouseRepository;
import com.Lidich.BitTestRestAPI.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CityService {
    private final ApartmentRepository apartmentRepository;
    private final CityRepository cityRepository;
    private final HouseRepository houseRepository;
    private final StreetRepository streetRepository;

    @Autowired
    public CityService(ApartmentRepository apartmentRepository,
                       CityRepository cityRepository,
                       HouseRepository houseRepository,
                       StreetRepository streetRepository){
        this.apartmentRepository = apartmentRepository;
        this.cityRepository = cityRepository;
        this.houseRepository = houseRepository;
        this.streetRepository = streetRepository;
    }

    @Transactional
    public List<CityAndHouseCountDto> getCitiesWithNumberOfHousesList(){
        List<City> cityList = cityRepository.findAll();
        List<CityAndHouseCountDto> cityAndHouseCountDtoList = new ArrayList<>();

        for (City city : cityList) {
            int count = 0;
            List<Street> streetList = city.getStreetList();

            for (Street tempStreet : streetList) {
                count += tempStreet.getHouseList().size();
                System.out.println(count);
            }
            cityAndHouseCountDtoList.add(new CityAndHouseCountDto(city, count));
        }

        return (cityAndHouseCountDtoList);
    }
}
