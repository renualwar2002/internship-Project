package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class About extends AppCompatActivity {
    TextView id,nam,dat;
    List<String> listViewValues;
    ArrayList<String> listviewdetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        nam=findViewById(R.id.name);
        id=findViewById(R.id.idno);
        dat=findViewById(R.id.dob);
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
                    String idno = obj.getString("naanmudhalvanid");
                    String Name = obj.getString("name");
                    String date = obj.getString("dob");
                    id.setText("NaanMudvalanid:" + idno);
                    nam.setText("Name:" + Name);
                    dat.setText("Date of Birth:" + date);
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