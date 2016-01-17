package com.example.subss.icare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewProfileActivity extends AppCompatActivity {

    String userName;
    TextView userNameTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        userName = getIntent().getStringExtra("username");

        userNameTV = (TextView) findViewById(R.id.usernameTV);
        userNameTV.setText(userName);
    }
}
