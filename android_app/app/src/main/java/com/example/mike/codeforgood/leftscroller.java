package com.example.mike.codeforgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import android.os.AsyncTask;
public class leftscroller extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leftscroller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        requestQueue = Volley.newRequestQueue(this);

        getSupportActionBar().setTitle("Your Balance");

        TextView balance = (TextView) findViewById(R.id.balance);

        // Needs to be changed to real time data -- connect to DB
        //balance.setText("Balance: $ " + "5.00");
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.leftscroller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Balance
            // Do we need to do this? -- Redundant?
            startActivity(new Intent(leftscroller.this, leftscroller.class));
        } else if (id == R.id.nav_gallery) {
            // Location -- Google Maps
            startActivity(new Intent(leftscroller.this, google_maps.class));
        } else if (id == R.id.nav_slideshow) {
            // Sign Out
            startActivity(new Intent(leftscroller.this, SignIn.class));
        } /*else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void getJSON(){
        JsonObjectRequest jsonObjectRequest =  new JsonObjectRequest( "http://10.88.3.169:8080/getBalance/jkim/",null
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


