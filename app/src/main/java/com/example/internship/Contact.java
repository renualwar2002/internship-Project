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

public class Contact extends AppCompatActivity {
    List<String> listViewValues;
    TextView email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phno);
        Intent intent=getIntent();
        String item = intent.getStringExtra("name");
        TextView result = findViewById(R.id.textView2);
        result.setText("About  "+item);
        String namecheck=intent.getStringExtra("name");
        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");
            listViewValues = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("email");
                String Name = obj.getString("mobilenumber");
                email.setText("Email :" +name);
                phone.setText("Mobile Number:" + Name);
                if(namecheck.equals(Name)){
                    break;
                }




            }
        }
        catch (Exception e){
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
        json=new String(byteArray, "UTF-8");
        return json;
    }

}
