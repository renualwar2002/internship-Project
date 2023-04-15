package com.example.internship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {

    Button buttonxml2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Find the button by its id
        buttonxml2 = findViewById(R.id.buttonofxml2);

        // Set an OnClickListener to the button
        buttonxml2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Create an Intent to start MainActivity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                // Start the MainActivity
                startActivity(intent);
            }
        });
    }
}