package com.Lidich.BitTestRestAPI.repositories;

import com.Lidich.BitTestRestAPI.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    City findCityByNameIgnoreCase(String name);
}
