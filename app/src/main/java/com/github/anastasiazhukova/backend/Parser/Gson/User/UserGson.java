package com.github.anastasiazhukova.backend.Parser.Gson.User;

import com.github.anastasiazhukova.backend.Parser.IUser.IUser;
import com.google.gson.annotations.SerializedName;

public class UserGson implements IUser {

    @SerializedName("id")
    private Long id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + firstName + " " + lastName;
    }
}
