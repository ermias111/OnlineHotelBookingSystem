package com.example.hbs.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Customer extends Account implements Serializable{

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Email(message = "Email should be valid",regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Booking> bookings;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String email, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }

    public Customer(String username, String password, Role role, String firstname, String lastname) {
        super(username, password, role);
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public Customer(String username, String password, Role role, String firstname, String lastname, String email) {
        super(username, password, role);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Customer(String username, String password, Role role, String firstname, String lastname, String email, Address address) {
        super(username, password, role);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
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

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
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
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, address);
    }
}
