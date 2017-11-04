package com.example.mike.codeforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class congrats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        getSupportActionBar().setTitle("Congratulations");

        Button continueButton = (Button) findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(congrats.this, leftscroller.class));
            }
        });
    }
}
