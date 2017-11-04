package com.example.mike.codeforgood;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(android.R.style.Theme_Holo);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setTitle("Sign In");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#8BC34A")));
        Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().trim().equals("") &&
                        !password.getText().toString().trim().equals("")) {
                    Intent phone = new Intent(SignIn.this, leftscroller.class);
                    phone.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(phone);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please enter username and " +
                            "password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, Register.class));
            }
        });
    }
}
