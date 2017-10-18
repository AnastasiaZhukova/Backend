package com.github.anastasiazhukova.backend.Parser;

import com.github.anastasiazhukova.backend.Parser.Gson.Backend.BackendResponseParserGson;
import com.github.anastasiazhukova.backend.Parser.IBackend.IBackendResponseParser;

import java.io.InputStream;

public class BackendResponseParserFactory {

    public IBackendResponseParser createParserForGsonUsersLis(final InputStream pInputStream) {
        return new BackendResponseParserGson(pInputStream);
    }
}
