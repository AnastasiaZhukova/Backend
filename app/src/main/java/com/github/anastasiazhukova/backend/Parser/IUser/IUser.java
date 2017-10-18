package com.github.anastasiazhukova.backend.Parser.IUser;

public interface IUser {

    Long getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPassword();

    @Override
    String toString();
}
