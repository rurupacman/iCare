package com.example.subss.icare;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SubSs on 1/15/2016.
 */
public class SignUp extends Activity {

    EditText usernameET;
    EditText nameET;
    EditText emailET;
    EditText passwordET;
    EditText cpasswordET;

    String usernameStr;
    String nameStr;
    String emailStr;
    String passwordStr;
    String cpasswordStr;

    ContactClass contact;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        usernameET = (EditText) findViewById(R.id.usernameET);
        nameET = (EditText) findViewById(R.id.nameET);
        emailET = (EditText) findViewById(R.id.emailET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        cpasswordET = (EditText) findViewById(R.id.cpasswordET);

    }

    public void signup(View view) {

        usernameStr = usernameET.getText().toString();
        nameStr = nameET.getText().toString();
        emailStr = emailET.getText().toString();
        passwordStr = passwordET.getText().toString();
        cpasswordStr = cpasswordET.getText().toString();

        if (!passwordStr.equals(cpasswordStr)) {
                //popup message
                Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //inset data to userDatabase.db
            contact = new ContactClass();
            contact.setUsername(usernameStr);
            contact.setName(nameStr);
            contact.setEmail(emailStr);
            contact.setPassword(passwordStr);

            helper.insertContact(contact);
        }

    }
}
