package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 2000)
    private String description;

    @Column
    private String photoUrl;

    @Column
    private Double price;

    @Column
    private Boolean vacant;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "roomType_id")
    private RoomType roomType;

    public Room(Integer id, String description, String photoUrl, Double price, Boolean vacant, Hotel hotel, RoomType roomType) {
        this.id = id;
        this.description = description;
        this.photoUrl = photoUrl;
        this.price = price;
        this.vacant = vacant;
        this.hotel = hotel;
        this.roomType = roomType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getVacant() {
        return vacant;
    }

    public void setVacant(Boolean vacant) {
        this.vacant = vacant;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(description, room.description) &&
                Objects.equals(photoUrl, room.photoUrl) &&
                Objects.equals(price, room.price) &&
                Objects.equals(vacant, room.vacant) &&
                Objects.equals(hotel, room.hotel) &&
                Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, photoUrl, price, vacant, hotel, roomType);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", price=" + price +
                ", vacant=" + vacant +
                ", hotel=" + hotel +
                ", roomType=" + roomType +
                '}';
    }
}
