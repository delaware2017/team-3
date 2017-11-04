package com.example.mike.codeforgood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorReload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_reload);

        final EditText reText = (EditText) findViewById(R.id.amount);

        getSupportActionBar().setTitle("Reload");

        Button reload = (Button) findViewById(R.id.reload);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = reText.getText().toString().trim();
                if (!amount.equals("")) {

                    int numAmount = Integer.parseInt(amount);

                    //PUSH 'numAmount' TO THE DATABASE/////////


                    Toast.makeText(getApplicationContext(), numAmount + " added to the account", Toast.LENGTH_SHORT);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter a balance", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
