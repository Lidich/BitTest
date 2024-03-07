package com.Lidich.BitTestRestAPI.repositories;

import com.Lidich.BitTestRestAPI.entities.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
