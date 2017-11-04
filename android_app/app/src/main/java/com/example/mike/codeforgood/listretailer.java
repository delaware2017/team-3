package com.example.mike.codeforgood;

import android.app.Activity;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class listretailer extends AppCompatActivity implements ListAdapter{

    private final Activity activity;
    private final JSONArray jsonArray;


    private listretailer(Activity activity, JSONArray jsonArray){
        assert activity != null;
        assert jsonArray != null;

        this.jsonArray = jsonArray;
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listretailer);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public JSONObject getItem(int position) {
        return jsonArray.optJSONObject(position);
    }

    @Override
    public long getItemId(int position) {
        JSONObject jsonObject = getItem(position);
        return jsonObject.optLong("id");
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = activity.getLayoutInflater().inflate(R.layout.activity_listretailer, null);

        JSONObject jsonObject = getItem(position);

        return convertView;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
