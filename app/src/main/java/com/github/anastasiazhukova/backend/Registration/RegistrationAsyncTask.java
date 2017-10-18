package com.github.anastasiazhukova.backend.Registration;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.example.asus.myapplication.backendregistration.userApi.UserApi;
import com.github.anastasiazhukova.backend.UserApiConstants;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class RegistrationAsyncTask extends AsyncTask<Pair<Context, RegistrationInfo>, Void, String> {

    public static final String ERROR = "There is an error during registration";
    public static final String SUCCESS = "Successfully registered";
    private static UserApi myUserApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, RegistrationInfo>... params) {

        if (myUserApiService == null) {  // Only do this once
            UserApi.Builder builder = new UserApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(UserApiConstants.BACKEND_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {

                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myUserApiService = builder.build();
        }
        context = params[0].first;
        RegistrationInfo registrationInfo = params[0].second;
        try {
            myUserApiService.insert(registrationInfo.getFirstName(), registrationInfo.getLastName(),
                    registrationInfo.getEmail(), registrationInfo.getPassword()).execute();
        } catch (IOException pE) {
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }

}


