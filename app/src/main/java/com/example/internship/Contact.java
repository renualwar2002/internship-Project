package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class Contact extends AppCompatActivity {

    TextView txtTitle, txtBanner, txtDescription;
    Button btnViewPhoto;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact2);
        // Initialize views
        imageView = findViewById(R.id.imageView);
        txtTitle = findViewById(R.id.txt_up);
        txtBanner = findViewById(R.id.txt_banner);
        txtDescription = findViewById(R.id.txt_down);
        btnViewPhoto = findViewById(R.id.button1);

        // Get details from previous activity
        String details = getIntent().getStringExtra("message_key");

        // Display details in the title
        txtTitle.setText(details);
        btnViewPhoto.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), photoView.class));
            finish();
        });
    }
}

