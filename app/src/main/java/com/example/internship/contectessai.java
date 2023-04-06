package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class contectessai extends AppCompatActivity {

    TextView age3,add3,phone3,   name2;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contectessai);
        name2=findViewById(R.id.name2);
        age3=findViewById(R.id.age2);
        add3=findViewById(R.id.add2);
        phone3=findViewById(R.id.mobile2);
        Intent intent=getIntent();
        String item = intent.getStringExtra("name");
        TextView result = findViewById(R.id.textView2);
        result.setText("Contect  "+item);
        String namecheck=intent.getStringExtra("name");
        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String Name = obj.getString("name");
                    String ag = obj.getString("age");
                    String addss = obj.getString("address");
                    String em= obj.getString("mobilenumber");
                    age3.setText("Age:" +ag);
                    add3.setText("Address:"+addss);
                    phone3.setText("MobileNo:"+em);
                if(namecheck.equals(Name)){
                    break;
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private String loadJsonFile() throws IOException {
        String json=null;
        InputStream inputStream=this.getAssets().open("studentdetails.json");
        int size=inputStream.available();
        byte[] byteArray=new byte[size];
        inputStream.read(byteArray);
        inputStream.close();
        json=new String(byteArray, "UTF-8");
        return json;
    }
}