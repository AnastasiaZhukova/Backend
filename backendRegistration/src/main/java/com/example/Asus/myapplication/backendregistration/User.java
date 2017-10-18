package com.example.Asus.myapplication.backendregistration;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class User {

    //will be used to set ids for new users
    private static Long lastId = 0L;

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User() {
    }

    public User(String pFirstName, String pLastName, String pEmail, String pPassword) {
        firstName = pFirstName;
        lastName = pLastName;
        email = pEmail;
        password = pPassword;
        lastId++;
        id = lastId;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
