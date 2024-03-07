package com.Lidich.BitTestRestAPI.repositories;

import com.Lidich.BitTestRestAPI.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    House findHouseByStreet_IdAndNumber(Long street_id, String number);
}
