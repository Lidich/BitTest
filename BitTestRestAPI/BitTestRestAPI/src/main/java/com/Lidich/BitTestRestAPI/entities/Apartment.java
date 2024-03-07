package com.Lidich.BitTestRestAPI.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Apartments")
public class Apartment {

    private @Id @GeneratedValue Long id;
    private float area;

    @ManyToOne
    @JoinColumn(name="house_id", nullable = false)
    @JsonBackReference
    private House house;

    public Apartment() {}

    public Apartment(float area, House house){
        this.area = area;
        this.house = house;
    }

    public Apartment(float area){
        this.area = area;
    }

    Apartment(float area, int house_id){
        this.area = area;
    }

    public House getHouse() {
        return house;
    }

    public Long getId() {
        return id;
    }

    public float getArea() {
        return area;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArea(float area) {
        this.area = area;
    }
}
