package com.github.anastasiazhukova.backend.AllUsers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.github.anastasiazhukova.backend.HttpClient.HttpClient;
import com.github.anastasiazhukova.backend.HttpClient.IHttpClient;
import com.github.anastasiazhukova.backend.Parser.BackendResponseParserFactory;
import com.github.anastasiazhukova.backend.Parser.IBackend.IBackendResponse;
import com.github.anastasiazhukova.backend.Parser.IUser.IUser;
import com.github.anastasiazhukova.backend.UserApiConstants;

import java.io.InputStream;
import java.util.List;

public class UsersListLoader extends AsyncTask<Context, Void, List<IUser>> {

    private static final String NO_DATA = "No data";

    private IBackendResponse mBackendResponse;
    private Context context;

    @Override
    protected List<IUser> doInBackground(Context... params) {

        final BackendResponseParserFactory backendResponseParserFactory = new BackendResponseParserFactory();
        IHttpClient httpClient = new HttpClient();

        mBackendResponse = null;

        httpClient.request(UserApiConstants.USER_URL, new HttpClient.ResponseListener() {

            @Override
            public void onResponse(InputStream inputStream) {
                try {
                    if (inputStream == null) {
                        Log.d("HTTP", "Input stream is empty");
                        return;
                    }
                    mBackendResponse = backendResponseParserFactory.createParserForGsonUsersList(inputStream).parse();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        context = params[0];
        return mBackendResponse.getUsersList();
    }

    @Override
    protected void onPostExecute(List<IUser> s) {
        if (s.isEmpty() || s == null) {
            Toast.makeText(context, NO_DATA, Toast.LENGTH_LONG).show();
        }
    }
}
