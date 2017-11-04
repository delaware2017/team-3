package com.example.mike.codeforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createlogin);
        getSupportActionBar().setTitle("Create Profile");

        Button signup = (Button) findViewById(R.id.signupButton);
        final EditText newusername = (EditText) findViewById(R.id.newusername);
        final EditText password1 = (EditText) findViewById(R.id.password1);
        final EditText password2 = (EditText) findViewById(R.id.password2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checks username availability with DB
                String str = "";
                Boolean userFlag = false;
                Boolean passwordFlag1 = false;
                Boolean passwordFlag2 = false;

                if((newusername.getText().toString().trim().equals(""))){
                    // Says username is not available or is invalid
                    str = "That username is either blank or is taken. Please try again.";
                    userFlag = true;
                }
                if((password2.getText().toString().trim().equals(""))
                        || (password1.getText().toString().trim().equals(""))){
                    str = "Pleae enter a valid password";
                    passwordFlag1 = true;
                }
                if(!(password1.getText().toString().trim().equals(password2.getText().toString().trim()))){
                    str = "Password does not match. Please try again.";
                    passwordFlag2 = true;
                }
                if(userFlag || passwordFlag1 || passwordFlag2) {
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }
                // If flags aren't triggered
                else{
                    startActivity(new Intent(createlogin.this, congrats.class));
                }

                // Checks with DB if username is available
                // Stores new username and password into DB
            }
        });
    }
}
