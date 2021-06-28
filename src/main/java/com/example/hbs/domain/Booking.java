package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Column
    @Temporal(TemporalType.DATE)
    private Date check_in;

    @Column
    @Temporal(TemporalType.DATE)
    private Date check_out;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "roomId")
    private List<Room> rooms;

    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

    public Booking(){}

    public Booking(Date check_in, Date check_out, Customer customer, List<Room> rooms, Payment payment) {
//        this.created_at = created_at;
        this.check_in = check_in;
        this.check_out = check_out;
        this.customer = customer;
        this.rooms = rooms;
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(created_at, booking.created_at) && Objects.equals(check_in, booking.check_in) && Objects.equals(check_out, booking.check_out) && Objects.equals(customer, booking.customer) && Objects.equals(rooms, booking.rooms) && Objects.equals(payment, booking.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(check_in, check_out, customer, rooms, payment);
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
