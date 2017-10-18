package com.github.anastasiazhukova.backend.HttpClient;

public interface IHttpClient {

    void request(String url, HttpClient.ResponseListener listener);
}
