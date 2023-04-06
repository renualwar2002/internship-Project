package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import android.content.Intent;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    TextView id2,name2,dat2;
    List<String> listViewValues;
    ArrayList<String> listviewdetails = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        name2=findViewById(R.id.name2);
        id2=findViewById(R.id.idno2);
        dat2=findViewById(R.id.dob2);
        Intent intent=getIntent();
        String item = intent.getStringExtra("name");
        TextView result = findViewById(R.id.textView2);
        result.setText("About "+item);
        String namecheck=intent.getStringExtra("name");
        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");

            for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String idno = obj.getString("naanmudhalvanid");
                    String Name = obj.getString("name");
                    String date= obj.getString("dob");
                    name2.setText("Name:" +Name);
                    id2.setText("NaanMudvalanid:" +idno);
                    dat2.setText("Date of Birth:"+date);
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
