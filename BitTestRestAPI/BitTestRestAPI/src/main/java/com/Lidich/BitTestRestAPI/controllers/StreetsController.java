package com.Lidich.BitTestRestAPI.controllers;

import com.Lidich.BitTestRestAPI.dto.StreetsAndHouseCountDto;
import com.Lidich.BitTestRestAPI.services.StreetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StreetsController {
    private final StreetService streetService;

    StreetsController(StreetService streetService){
        this.streetService = streetService;
    }

    @Operation(summary = "Get перечень улиц с указанием количества домов с запросом по городу  /streets?city_id={city_id}",
            description = "Returns перечень улиц с указанием количества домов с запросом по городу  /streets?city_id={city_id}")
    @GetMapping("/streets")
    List<StreetsAndHouseCountDto> getStreetsAndHouseCount(@RequestParam Long city_id){
        return streetService.streetsAndHouseCountDtoList(city_id);
    }
}
