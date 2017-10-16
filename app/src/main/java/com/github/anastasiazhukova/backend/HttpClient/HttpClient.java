package com.github.anastasiazhukova.backend.HttpClient;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient implements IHttpClient {

    @Override
    public void request(final String url, final ResponseListener listener) {
        try {
            final HttpURLConnection con = (HttpURLConnection) (new URL(url)).openConnection();
            final InputStream is = con.getInputStream();
            listener.onResponse(is);
            con.disconnect();
        } catch (final Throwable t) {
            t.printStackTrace();
        }
    }

    public interface ResponseListener {

        void onResponse(InputStream inputStream);
    }

}
