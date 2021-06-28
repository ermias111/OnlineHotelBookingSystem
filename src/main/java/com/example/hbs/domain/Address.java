package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @Column
    private String address;

    @Column
    private String address2;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String postalCode;

    @Column
    private String phone;

    public Address(){}

    public Address(String address, String district, String city, String postalCode, String phone) {
        this.address = address;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public Address(String address, String address2, String district, String city, String postalCode, String phone) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) &&
                Objects.equals(address, address1.address) &&
                Objects.equals(address2, address1.address2) &&
                Objects.equals(district, address1.district) &&
                Objects.equals(city, address1.city) &&
                Objects.equals(postalCode, address1.postalCode) &&
                Objects.equals(phone, address1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, address2, district, city, postalCode, phone);
    }
}
