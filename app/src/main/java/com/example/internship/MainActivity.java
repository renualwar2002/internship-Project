package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    List<String> listViewValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview= findViewById(R.id.mobile_list);
        try {
            JSONObject jsonObject=new JSONObject(loadJsonFile());
            JSONArray jsonArray=jsonObject.getJSONArray("studentdetails");
            listViewValues = new ArrayList<>();
            for(int i=0; i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String name=obj.getString("name");
                listViewValues.add(name);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.displayname, listViewValues);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener((parent, view, position, id) -> {
                Intent profile = new Intent(this,ProfileActivity.class);
                    try {
                        profile.putExtra("name",jsonArray.getJSONObject(position).getString("name"));
                        profile.putExtra("id",jsonArray.getJSONObject(position).getString("naanmudhalvanid"));
                        profile.putExtra("dob",jsonArray.getJSONObject(position).getString("dob"));
                        profile.putExtra("college",jsonArray.getJSONObject(position).getString("collegename"));
                        profile.putExtra("standard",jsonArray.getJSONObject(position).getString("standard"));
                        profile.putExtra("address",jsonArray.getJSONObject(position).getString("address"));
                        profile.putExtra("email",jsonArray.getJSONObject(position).getString("email"));
                        profile.putExtra("mobile",jsonArray.getJSONObject(position).getString("mobilenumber"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    startActivity(profile);
            });
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public String loadJsonFile() throws IOException {
        String json=null;
        InputStream inputStream=this.getAssets().open("studentdetails.json");
        int size=inputStream.available();
        byte[] byteArray=new byte[size];
        inputStream.read(byteArray);
        inputStream.close();
        json=new String(byteArray, StandardCharsets.UTF_8);
        return json;
    }
}