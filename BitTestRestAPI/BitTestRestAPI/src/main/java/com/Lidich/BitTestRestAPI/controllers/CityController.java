package com.Lidich.BitTestRestAPI.controllers;

import com.Lidich.BitTestRestAPI.dto.CityAndHouseCountDto;
import com.Lidich.BitTestRestAPI.entities.City;
import com.Lidich.BitTestRestAPI.repositories.CityRepository;
import com.Lidich.BitTestRestAPI.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    private final CityService cityService;

    CityController(CityService cityService) {this.cityService = cityService;}

    @Operation(summary = "Get перечень городов с указанием количества домов", description = "Returns перечень городов с указанием количества домов")
    @GetMapping("/cities")
    List<CityAndHouseCountDto> getCitiesWithHouses(){
        return cityService.getCitiesWithNumberOfHousesList();
    }

}
