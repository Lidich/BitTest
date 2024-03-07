package com.Lidich.BitTestRestAPI.controllers;

import com.Lidich.BitTestRestAPI.dto.HouseWithAddressAndApartmentCountDto;
import com.Lidich.BitTestRestAPI.entities.House;
import com.Lidich.BitTestRestAPI.exeptions.EntityNotFoundException;
import com.Lidich.BitTestRestAPI.services.HouseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouseController {
    private final HouseService houseService;

    HouseController(HouseService houseService){
        this.houseService = houseService;
    }

    @Operation(summary = "Get перечень домов с указанием полного адреса и количества квартир с запросом по конкретной улице / городу  /houses?city_id={city_id} и /houses? street_id={street_id}",
            description = "Returns перечень домов с указанием полного адреса и количества квартир с запросом по конкретной улице / городу  /houses?city_id={city_id} и /houses? street_id={street_id}")
    @GetMapping("/houses")
    List<HouseWithAddressAndApartmentCountDto> getHousesByCityOrStreet(@RequestParam(required = false) Long city_id, @RequestParam(required = false) Long street_id){
        if(city_id!=null) return houseService.getHousesWithAddressByCity(city_id);
        if(street_id!=null) return houseService.getHousesWithAdressByStreet(street_id);
        else throw (new EntityNotFoundException());
    }

    @Operation(summary = "Get id дома по строке с его полным адресом",
            description = "Для распознавания строка должна соответствовать следующему шаблону: " +
                    "city: Yaroslavl street: Tolbuhina house: 62"+
                    "где обязательно должны присутствовать слова: (city, street, house), а разделителями могут быть :, пробел, запятая"+
                    ".Returns id дома по строке с его полным адресом")
    @GetMapping("/findHouse")
    Long findHouseId(@RequestParam String address){
        return houseService.findHouseByAddress(address);
    }
}
