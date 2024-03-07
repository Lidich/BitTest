package com.Lidich.BitTestRestAPI.services;

import com.Lidich.BitTestRestAPI.dto.StreetsAndHouseCountDto;
import com.Lidich.BitTestRestAPI.entities.City;
import com.Lidich.BitTestRestAPI.entities.Street;
import com.Lidich.BitTestRestAPI.exeptions.EntityNotFoundException;
import com.Lidich.BitTestRestAPI.repositories.ApartmentRepository;
import com.Lidich.BitTestRestAPI.repositories.CityRepository;
import com.Lidich.BitTestRestAPI.repositories.HouseRepository;
import com.Lidich.BitTestRestAPI.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreetService {
    private final ApartmentRepository apartmentRepository;
    private final CityRepository cityRepository;
    private final HouseRepository houseRepository;
    private final StreetRepository streetRepository;

    @Autowired
    public StreetService(ApartmentRepository apartmentRepository,
                       CityRepository cityRepository,
                       HouseRepository houseRepository,
                       StreetRepository streetRepository){
        this.apartmentRepository = apartmentRepository;
        this.cityRepository = cityRepository;
        this.houseRepository = houseRepository;
        this.streetRepository = streetRepository;
    }

    @Transactional
    public List<StreetsAndHouseCountDto> streetsAndHouseCountDtoList(long cityId){
        City city = cityRepository.findById(cityId).orElseThrow(EntityNotFoundException::new);
        List<StreetsAndHouseCountDto> streetsAndHouseCountDtoList = new ArrayList<>();

        List<Street> streetList = city.getStreetList();

        for(Street street: streetList){
            int count = street.getHouseList().size();
            streetsAndHouseCountDtoList.add(new StreetsAndHouseCountDto(street.getName(), count));
        }
        return (streetsAndHouseCountDtoList);
    }
}
