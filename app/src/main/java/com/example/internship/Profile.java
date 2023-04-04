package com.example.internship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.profile);
        Button about=(Button)findViewById(R.id.about);
        TextView profileName=(TextView)findViewById(R.id.profileName);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        profileName.setText(name);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
