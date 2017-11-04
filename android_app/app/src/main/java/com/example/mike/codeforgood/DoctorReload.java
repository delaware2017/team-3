package com.example.mike.codeforgood;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class DoctorReload extends AppCompatActivity {

    RequestQueue requestQueue;
    EditText reText, user;
    String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_reload);

        reText = (EditText) findViewById(R.id.amount);
        user = (EditText) findViewById(R.id.name);

        getSupportActionBar().setTitle("Reload");

        Button reload = (Button) findViewById(R.id.reload);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount = reText.getText().toString().trim();
                if (!amount.equals("")) {

                    int numAmount = Integer.parseInt(amount);

                    Toast.makeText(getApplicationContext(), numAmount + " added to the account", Toast.LENGTH_SHORT);
                    new AsyncTask<Integer,Void,Void>(){
                        protected Void doInBackground(Integer... params) {
                            try {
                                getJSON();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return null;
                        }

                    }.execute(1);

                    //PUSH 'numAmount' TO THE DATABASE/////////
                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter a balance", Toast.LENGTH_SHORT);
                }
            }
        });

    }

    public void getJSON(){
        String username = user.getText().toString().trim();
        JsonObjectRequest jsonObjectRequest =  new JsonObjectRequest( "http://10.88.3.169:8080/reload/username/amount/",null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // JSONObject jsonObject = response.getJSONObject("UserId")
                    TextView balance = (TextView) findViewById(R.id.balance);

                    balance.setText("Balance: " + response.getString("balance"));
//                    JSONArray jsonArray = response.getJSONArray("");
//                    for(int i =0;i<jsonArray.length();i++) {
//                        JSONObject user = jsonArray.getJSONObject(i);
//                        String userId = user.getString("userId");
//                        Log.d(TAG,userId);
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
