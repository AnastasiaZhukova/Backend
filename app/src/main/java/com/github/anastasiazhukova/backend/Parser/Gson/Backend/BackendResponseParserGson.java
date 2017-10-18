package com.github.anastasiazhukova.backend.Parser.Gson.Backend;

import com.github.anastasiazhukova.backend.Parser.IBackend.IBackendResponse;
import com.github.anastasiazhukova.backend.Parser.IBackend.IBackendResponseParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BackendResponseParserGson implements IBackendResponseParser {

    private final InputStream mInputStream;

    public BackendResponseParserGson(InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IBackendResponse parse() throws Exception {
        Reader reader = new InputStreamReader(mInputStream);
        return new Gson().fromJson(reader, BackendResponseGson.class);
    }
}
