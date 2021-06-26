package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name="hotel")
@Entity
public class Hotel extends Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(length = 2000)
    private String description;

    @Column
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Hotel(){}

    public Hotel(String name, String description, String photoUrl,Address address) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.address = address;
      //  this.account = account;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", address=" + address +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(description, hotel.description) &&
                Objects.equals(photoUrl, hotel.photoUrl) &&
                Objects.equals(account, hotel.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, photoUrl, account);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}