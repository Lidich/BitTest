package com.Lidich.BitTestRestAPI.repositories;

import com.Lidich.BitTestRestAPI.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
    public Street findStreetByCity_IdAndNameIgnoreCase(Long city_id, String name);
}
