package com.github.anastasiazhukova.backend.Registration;

public class RegistrationInfo {

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mPassword;

    public RegistrationInfo(String pFirstName, String pLastName, String pEmail, String pPassword) {
        mFirstName = pFirstName;
        mLastName = pLastName;
        mEmail = pEmail;
        mPassword = pPassword;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }
}
