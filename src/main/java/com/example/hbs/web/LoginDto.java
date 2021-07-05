package com.example.hbs.web;

import com.example.hbs.domain.Address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginDto {
    @NotNull
    private String username;

    @NotNull
    private String password;

    private String firstname;

    private String lastname;

    private String name;

    private String description;

    private String photoUrl;

    private String email;

    private Address address;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static  boolean valid_num(String num,int length){
        if (num==null)return false;
        Pattern pattern = Pattern.compile("^\\d{"+length+"}$");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
    /**
     * Default constructor
     */
    protected LoginDto() {
    }

    public LoginDto(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

    public LoginDto(@NotNull String username, @NotNull String password, String firstname, String lastname, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;

        this.email = email;
    }

    public LoginDto(@NotNull String username, @NotNull String password, String name, String description, String photoUrl, Address address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
