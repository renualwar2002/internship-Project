package com.example.internship;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    TextView txt_up;

    List<String> listViewValues;
    List<String> listViewDetails = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.mobile_list);
        txt_up = findViewById(R.id.txt_up);




        listview.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(MainActivity.this, "You will be redirected to"+"  "+ listViewValues.get(i)+"  "+"Profile", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, photoView.class);

            intent.putExtra("details", listViewDetails.get(i));
            startActivity(intent);

        });


        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");
            listViewValues = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String details = obj.toString();
                listViewValues.add(name);
                listViewDetails.add(details);


            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.displayname, listViewValues);
            listview.setAdapter(adapter);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public String loadJsonFile() throws IOException {
        String json;
        InputStream inputStream=this.getAssets().open("studentdetails.json");
        int size=inputStream.available();
        byte[] byteArray=new byte[size];
        inputStream.read(byteArray);
        inputStream.close();
        json=new String(byteArray, StandardCharsets.UTF_8);
        return json;
    }
}