package com.example.hbs.domain;

import com.example.hbs.service.AccountService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
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
        this.created_at = new java.sql.Timestamp(System.currentTimeMillis());
        this.last_update = new java.sql.Timestamp(System.currentTimeMillis());

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(username, account.username) &&
                Objects.equals(password, account.password) &&
                Objects.equals(role, account.role) &&
                Objects.equals(created_at, account.created_at) &&
                Objects.equals(last_update, account.last_update);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, created_at, last_update);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created_at=" + created_at +
                ", last_update=" + last_update +
                '}';
    }
}
