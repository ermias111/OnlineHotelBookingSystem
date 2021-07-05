package com.example.hbs.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Admin extends Account implements Serializable {

    public Admin(){}

    public Admin(String username, String password, Role role) {
        super(username, password, role);
    }


}
