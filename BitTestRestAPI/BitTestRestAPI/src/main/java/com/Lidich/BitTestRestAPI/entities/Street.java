package com.Lidich.BitTestRestAPI.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Streets")
public class Street {
    private @Id @GeneratedValue Long id;
    private String name;

    @OneToMany(mappedBy = "street")
    @JsonManagedReference
    private List<House> houseList;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonBackReference
    private City city;

    public Street(){}

    public Street(String name, City city){
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }
}
