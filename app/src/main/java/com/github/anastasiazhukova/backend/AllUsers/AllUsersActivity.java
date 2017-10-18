package com.github.anastasiazhukova.backend.AllUsers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.anastasiazhukova.backend.Parser.IUser.IUser;
import com.github.anastasiazhukova.backend.R;

import java.util.List;

public class AllUsersActivity extends AppCompatActivity {

    private TextView mUsersTextView;
    private ScrollView mUsersScrollView;
    private List<IUser> mUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadUsersList();
        showUsersList();
    }

    public void initViews() {
        mUsersTextView = (TextView) findViewById(R.id.textView_users);
        mUsersScrollView = (ScrollView) findViewById(R.id.scrollView_users);
    }

    public void loadUsersList() {
        UsersListLoader usersListLoader = new UsersListLoader();
        usersListLoader.execute(this);
        try {
            mUsersList = usersListLoader.get();
        } catch (Exception pE) {
            Log.e("All users", "Some errors");
        }
    }

    public void showUsersList() {
        if (mUsersList != null) {
            StringBuilder stringBuilder = new StringBuilder();
            List<IUser> usersList = mUsersList;
            if (!usersList.isEmpty() && mUsersList != null) {
                for (IUser user :
                        usersList) {
                    stringBuilder.append(user);
                    stringBuilder.append('\n');
                }
                mUsersTextView.setText(stringBuilder.toString());
            } else {
                mUsersTextView.setText("No data");
            }
        }
    }
}
