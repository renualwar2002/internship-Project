package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutMeActivity extends AppCompatActivity {

    private Button aboutMeButton;
    private Button academicButton;
    private Button contactMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        aboutMeButton = findViewById(R.id.about_me_button);
        academicButton = findViewById(R.id.academic_button);
        contactMeButton = findViewById(R.id.contact_me_button);

        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutMeActivity.this, "About Me Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboutMeActivity.this, AboutMeActivity2.class);
                startActivity(intent);
            }
        });

        academicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutMeActivity.this, "Academic Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        contactMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutMeActivity.this, "Contact Me Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
