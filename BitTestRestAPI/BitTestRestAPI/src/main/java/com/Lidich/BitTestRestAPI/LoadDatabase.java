package com.Lidich.BitTestRestAPI;

import com.Lidich.BitTestRestAPI.entities.Apartment;
import com.Lidich.BitTestRestAPI.entities.House;
import com.Lidich.BitTestRestAPI.entities.Street;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.Lidich.BitTestRestAPI.entities.City;
import com.Lidich.BitTestRestAPI.repositories.ApartmentRepository;
import com.Lidich.BitTestRestAPI.repositories.CityRepository;
import com.Lidich.BitTestRestAPI.repositories.HouseRepository;
import com.Lidich.BitTestRestAPI.repositories.StreetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ApartmentRepository apartmentRepository, CityRepository cityRepository, HouseRepository houseRepository, StreetRepository streetRepository){
        //preload Cities
        City yaroslavl = cityRepository.save(new City("Yaroslavl"));
        City moscow = cityRepository.save(new City("Moscow"));

        //preload Streets
        Street tolbuhinaStreet = streetRepository.save(new Street("Tolbuhina", yaroslavl));
        Street newtonStreet = streetRepository.save(new Street("Newton", yaroslavl));
        Street leninaStreet = streetRepository.save(new Street("Lenina", moscow));

        //preload Houses
        House tolbuhinaHouse62 = houseRepository.save(new House("62", tolbuhinaStreet));
        House tolbuhinaHouse55 = houseRepository.save(new House("55", tolbuhinaStreet));
        House tolbuhinaHouse122 = houseRepository.save(new House("122", tolbuhinaStreet));

        House newtonHouse441 = houseRepository.save(new House("441 ", newtonStreet));
        House newtonHouse23 = houseRepository.save(new House("23", newtonStreet));
        House newtonHouse14 = houseRepository.save(new House("14", newtonStreet));

        //preload Apartments
        Apartment tolbuhina62Apartment = apartmentRepository.save(new Apartment(3.14F, tolbuhinaHouse62));
        Apartment tolbuhina62Apartment2 = apartmentRepository.save(new Apartment(33.14F, tolbuhinaHouse62));
        Apartment tolbuhina62Apartment3 = apartmentRepository.save(new Apartment(333.14F, tolbuhinaHouse62));

        return args -> {

            //log.info("Preloading " + apartmentRepository.save(new Apartment(8.5F)));
            //log.error("Preloading " + cityRepository.save(yaroslavl));
            //log.error("Preloading " + cityRepository.save(moscow));
        };
    }
}
