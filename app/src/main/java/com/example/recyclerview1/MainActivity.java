package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> max_speed_list;
    private ArrayList<String> car_name_list;
    private String cars_json;
    private int cars_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        car_name_list = new ArrayList<>();
        max_speed_list = new ArrayList<>();
        cars_json = getJsonData("/Users/dzun/AndroidStudioProjects/RecyclerView1/app/assets/cars.json");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapter(car_name_list, max_speed_list));
    }

    private String getJsonData(String filename) {
        try {
            String data_json = "";
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            for (String line; (line = reader.readLine()) != null;) {
                data_json += line;
            }
            return data_json;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void parseJsonCars() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject cars = (JSONObject) parser.parse(cars_json);
            cars_count = 6;

            for (int i = 1; i <= cars_count; i++) {
                JSONObject obj = cars.getJSONObject("car" + i);
                car_name_list.add(obj.get("name").toString());
                max_speed_list.add(obj.get("max_speed").toString());
            }

        } catch (ParseException | JSONException e) {
            e.printStackTrace();
        }
    }
}