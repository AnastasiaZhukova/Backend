package com.github.anastasiazhukova.backend.Registration;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.anastasiazhukova.backend.R;

public class RegistrationActivity extends AppCompatActivity {

    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private View mSaveButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
    }

    private void initViews() {
        mFirstNameEditText = (EditText) findViewById(R.id.editText_FirstName);
        mLastNameEditText = (EditText) findViewById(R.id.editText_LastName);
        mEmailEditText = (EditText) findViewById(R.id.editText_email);
        mPasswordEditText = (EditText) findViewById(R.id.editText_password);
        mSaveButton = findViewById(R.id.button_save);
        mSaveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isFieldsEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                } else {
                    final String firstName = mFirstNameEditText.getText().toString();
                    final String lastName = mLastNameEditText.getText().toString();
                    final String email = mEmailEditText.getText().toString();
                    final String password = mPasswordEditText.getText().toString();
                    final RegistrationInfo registrationInfo = new RegistrationInfo(firstName, lastName, email, password);
                    new RegistrationAsyncTask().execute(new Pair<Context, RegistrationInfo>(RegistrationActivity.this, registrationInfo));
                    finish();
                }
            }
        });
    }

    private boolean isFieldsEmpty() {
        if (mFirstNameEditText.getText().toString().isEmpty()) {
            return true;
        }
        if (mLastNameEditText.getText().toString().isEmpty()) {
            return true;
        }
        if (mEmailEditText.getText().toString().isEmpty()) {
            return true;
        }
        if (mPasswordEditText.getText().toString().isEmpty()) {
            return true;
        }
        return false;
    }

}
