package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Column
    private Date check_in;

    @Column
    private Date check_out;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Booking(){}

    public Booking(Date created_at, Date check_in, Date check_out, Customer customer, Room room) {
        this.created_at = created_at;
        this.check_in = check_in;
        this.check_out = check_out;
        this.customer = customer;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", check_in=" + check_in +
                ", check_out=" + check_out +
                ", customer=" + customer +
                ", room=" + room +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(created_at, booking.created_at) &&
                Objects.equals(check_in, booking.check_in) &&
                Objects.equals(check_out, booking.check_out) &&
                Objects.equals(customer, booking.customer) &&
                Objects.equals(room, booking.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created_at, check_in, check_out, customer, room);
    }
}
