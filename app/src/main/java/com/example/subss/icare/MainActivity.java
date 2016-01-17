package com.example.subss.icare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameET;
    EditText passwordET;

    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);

        helper = new DatabaseHelper(this);
    }

    public void login(View view){
        String userNameStr = userNameET.getText().toString();
        String passwordStr = passwordET.getText().toString();

        String password = helper.searchPassword(userNameStr);

        if(passwordStr.equals(password)){

            Intent intent = new Intent(MainActivity.this, ViewProfileActivity.class);
            intent.putExtra("username", userNameStr);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(MainActivity.this, "User Name & Passwords don't match!", Toast.LENGTH_SHORT).show();
        }


    }
    public void signup(View view){

        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);

    }

}
