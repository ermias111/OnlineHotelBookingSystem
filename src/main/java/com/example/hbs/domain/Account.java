package com.example.hbs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date last_update;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "account_role",
            joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    /**
     * Default Constructor.
     */
    protected Account() {
    }

    public Account(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.roles = Arrays.asList(role);
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
