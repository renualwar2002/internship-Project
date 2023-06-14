package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class academic extends AppCompatActivity {
    TextView txt_down,txt_up,txt_banner;
    TextView textViewDetails;

    Button btnViewPhoto;
    ImageView image_view;

    ImageButton imageButton;
    //Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        image_view = findViewById(R.id.imageView);

        txt_banner = findViewById(R.id.txt_banner);
        txt_down = findViewById(R.id.txt_down);
        btnViewPhoto = findViewById(R.id.button1);
        imageButton = findViewById(R.id.imageButton2);


        textViewDetails = findViewById(R.id.txt_up);
        String details = getIntent().getStringExtra("message_key");

        // display the string into textView
        textViewDetails.setText(details);
        btnViewPhoto.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), photoView.class));
            finish();
        });

        imageButton.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), photoView.class));
            finish();
        });


    }
}