package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer id;

    @Column
    private  Integer room_number;

    @Column
    private Boolean vacant;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<Booking> bookings;

    public Room(){}

    public Room(Integer room_number, Boolean vacant, Hotel hotel, RoomType roomType, List<Booking> bookings) {
        this.room_number = room_number;
        this.vacant = vacant;
        this.hotel = hotel;
        this.roomType = roomType;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room_number=" + room_number +
                ", vacant=" + vacant +
                ", hotel=" + hotel +
                ", roomType=" + roomType +
                ", bookings=" + bookings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(room_number, room.room_number) &&
                Objects.equals(vacant, room.vacant) &&
                Objects.equals(hotel, room.hotel) &&
                Objects.equals(roomType, room.roomType) &&
                Objects.equals(bookings, room.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room_number, vacant, hotel, roomType, bookings);
    }
}
