package com.github.anastasiazhukova.backend.Parser.IBackend;

import com.github.anastasiazhukova.backend.Parser.IUser.IUsersListParser;

public interface IBackendResponseParser extends IUsersListParser {

    IBackendResponse parse() throws Exception;
}
