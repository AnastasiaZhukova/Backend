package com.github.anastasiazhukova.backend.Parser.Gson.Backend;

import com.github.anastasiazhukova.backend.Parser.Gson.User.UserGson;
import com.github.anastasiazhukova.backend.Parser.IBackend.IBackendResponse;
import com.github.anastasiazhukova.backend.Parser.IUser.IUser;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BackendResponseGson implements IBackendResponse {

    @SerializedName("items")
    private List<UserGson> mUsersList;

    @SerializedName("backendVersion")
    private int backendVersion;

    @Override
    public int getBackendVersion() {
        return backendVersion;
    }

    @Override
    public List<IUser> getUsersList() {
        final List<IUser> users = new ArrayList<>();
        for (final UserGson user :
                mUsersList) {
            users.add(user);
        }
        return users;
    }
}
