package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String type;

    @Column(length = 2000)
    private String description;

    @Column
    private String photoUrl;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hottel;

    public  RoomType(){}

    public RoomType(String type, String description, String photoUrl, Double price, Hotel hottel) {
        this.type = type;
        this.description = description;
        this.photoUrl = photoUrl;
        this.price = price;
        this.hottel = hottel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Hotel getHottel() {
        return hottel;
    }

    public void setHottel(Hotel hottel) {
        this.hottel = hottel;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", price=" + price +
                ", hottel=" + hottel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(id, roomType.id) &&
                Objects.equals(type, roomType.type) &&
                Objects.equals(description, roomType.description) &&
                Objects.equals(photoUrl, roomType.photoUrl) &&
                Objects.equals(price, roomType.price) &&
                Objects.equals(hottel, roomType.hottel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, description, photoUrl, price, hottel);
    }
}