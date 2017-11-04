package com.example.mike.codeforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Registration");

        Button proceed = (Button) findViewById(R.id.proceedButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        final EditText tokenID = (EditText) findViewById(R.id.tokenID);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tokenID.getText().toString().equals(""))
                {
                    startActivity(new Intent(Register.this, createlogin.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please enter a valid " +
                            "token ID.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, SignIn.class));
            }
        });
    }
}
