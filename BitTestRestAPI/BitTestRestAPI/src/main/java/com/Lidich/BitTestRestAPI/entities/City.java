package com.Lidich.BitTestRestAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Cities")
@JsonIgnoreProperties(value = "houseList")
public class City {
    private @Id @GeneratedValue Long id;
    private String name;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<Street> streetList;

    public City(){}

    public City(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }
}
