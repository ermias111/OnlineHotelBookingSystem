package com.example.hbs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date last_update;


    /**
     * Default Constructor.
     */
    protected Account() {
    }

    public Account(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.created_at = new Date(System.currentTimeMillis());
        this.last_update = new Date(System.currentTimeMillis());

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
