package com.Lidich.BitTestRestAPI.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Houses")
public class House {
    private @Id @GeneratedValue Long id;
    private String number;

    @OneToMany(mappedBy = "house")
    @JsonManagedReference
    private List<Apartment> apartmentList;

    @ManyToOne
    @JoinColumn(name = "street_id", nullable = false)
    @JsonBackReference
    private Street street;

    public House(){}

    public House(String number, Street street){
        this.number = number;
        this.street = street;
    }

    House(String number, List<Apartment> apartmentList){
        this.number = number;
        this.apartmentList = apartmentList;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<Apartment> getApartmentList() {
        return apartmentList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApartmentList(Set<Apartment> apartmentSet) {
        this.apartmentList = apartmentList;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

