package com.github.anastasiazhukova.backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.anastasiazhukova.backend.AllUsers.AllUsersActivity;
import com.github.anastasiazhukova.backend.Registration.RegistrationActivity;

public class MainActivity extends AppCompatActivity {

    private View mRegisterButton;
    private View mShowAllButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void startRegistrationActivity() {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
    public void startAllUsersActivity() {
        startActivity(new Intent(this, AllUsersActivity.class));
    }

    public void initViews() {
        mRegisterButton = findViewById(R.id.button_register);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startRegistrationActivity();
            }
        });

        mShowAllButton=findViewById(R.id.button_showusers);
        mShowAllButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startAllUsersActivity();
            }
        });
    }
}
