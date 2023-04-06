package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class academicessai extends AppCompatActivity {

    TextView college,standard,email,name2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academicessai);
        college=findViewById(R.id.collegeid);
        name2=findViewById(R.id.name2);
        standard=findViewById(R.id.standard);
        email=findViewById(R.id.mail);
        Intent intent=getIntent();
        String item = intent.getStringExtra("name");
        TextView result = findViewById(R.id.textView3);
        result.setText("Academic  "+item);
        String namecheck=intent.getStringExtra("name");
        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String Name = obj.getString("name");
                String coll = obj.getString("collegename");
                String stan = obj.getString("standard");
                String em= obj.getString("email");
                college.setText("CollegeName:" +coll);
                standard.setText("Standard:"+stan);
                email.setText("Email:"+em);
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