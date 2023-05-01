package com.example.internship;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;

public class AboutMe extends AppCompatActivity {
    TextView about,id,username,dob;
    ImageButton backButton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        backButton = findViewById(R.id.back_button);

        try {
            JSONObject jsonObject=new JSONObject(loadJsonFile());
            JSONArray jsonArray=jsonObject.getJSONArray("studentdetails");

            for(int i=0; i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String name_1=obj.getString("name");
                if(name_1.equals(name)){
                    about = findViewById(R.id.about);
                   id = findViewById(R.id.naan_mudhalvan_id);
                   username = findViewById(R.id.username);
                   dob = findViewById(R.id.date_of_birth);

                   about.setText("About " + name.split(" ",2)[0]);
                   id.setText("Naan Mudhalvan Id\n" + obj.getString("naanmudhalvanid"));
                   username.setText("Name\n" + name_1);
                   dob.setText("Date Of Birth\n" + obj.getString("dob"));
                   break;
                }

            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        backButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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