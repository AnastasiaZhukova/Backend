package com.github.anastasiazhukova.backend.Parser.IBackend;

import com.github.anastasiazhukova.backend.Parser.IUser.IUsersList;

public interface IBackendResponse extends IUsersList {

    int getBackendVersion();
}
