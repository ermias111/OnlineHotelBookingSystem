package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer extends Account implements Serializable{
    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String email, Address address, List<Booking> bookings) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.bookings = bookings;
    }

    public Customer(String username, String password, Role role, String firstname, String lastname, String email, Address address, List<Booking> bookings) {
        super(username, password, role);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.bookings = bookings;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", bookings=" + bookings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstname, customer.firstname) &&
                Objects.equals(lastname, customer.lastname) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(bookings, customer.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, address, bookings);
    }
}
