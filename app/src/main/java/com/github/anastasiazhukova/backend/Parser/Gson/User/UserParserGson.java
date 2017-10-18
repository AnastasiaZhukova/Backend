package com.github.anastasiazhukova.backend.Parser.Gson.User;

import com.github.anastasiazhukova.backend.Parser.IUser.IUser;
import com.github.anastasiazhukova.backend.Parser.IUser.IUserParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserParserGson implements IUserParser {

    private final InputStream mInputStream;

    public UserParserGson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IUser parse() throws Exception {
        final Reader reader = new InputStreamReader(mInputStream);
        return new Gson().fromJson(reader, UserGson.class);
    }
}
