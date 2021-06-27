package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Hotel extends Account implements Serializable {

    @Column
    private String name;

    @Column(length = 2000)
    private String description;

    @Column
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;




    public  Hotel(){}


    public Hotel(String name, String description, String photoUrl, Address address) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.address = address;
    }


    public Hotel(String username, String password, Role role,String name, String description, String photoUrl, Address address) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) &&
                Objects.equals(description, hotel.description) &&
                Objects.equals(photoUrl, hotel.photoUrl) &&
                Objects.equals(address, hotel.address) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, photoUrl, address);
    }
}