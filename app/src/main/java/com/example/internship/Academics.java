package com.example.internship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Academics extends AppCompatActivity {
    TextView clg,name,std,profilename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academics);
//        name=findViewById(R.id.name);
        clg=findViewById(R.id.clg);
        std=findViewById(R.id.std);
        profilename=findViewById(R.id.profileName);
        ImageView profileImg1=(ImageView)findViewById(R.id.profileImg);
        Intent intent=getIntent();
        String namecheck=intent.getStringExtra("name");
        int img=intent.getIntExtra("imageid",0);
        profileImg1.setImageResource(img);
        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
//                String idno = obj.getString("naanmudhalvanid");
                String Name = obj.getString("name");
//                String date= obj.getString("dob");
//                id.setText("NaanMudvalanid:" +idno);
//                name.setText("Name:"+Name);
//                profilename.setText(Name);
//                dat.setText("Date of Birth:"+date);
                if(namecheck.equals(Name)){
                    String college = obj.getString("collegename");
                    String standard= obj.getString("standard");
                    clg.setText("College Name:  " +college);
                    profilename.setText(Name+" 's Academics");
                    std.setText("Standard:  "+standard);
                    break;
                }
            }
//            ImageView img= (ImageView) findViewById(R.id.profileImg);
//            img.setImageResource(R.drawable.);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
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