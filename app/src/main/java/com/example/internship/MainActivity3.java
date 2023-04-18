package com.example.internship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity3 extends AppCompatActivity {

    Button buttonxml3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Find the button by its id
        buttonxml3 = findViewById(R.id.buttonofxml3);

        // Set an OnClickListener to the button
        buttonxml3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start MainActivity
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                // Start the MainActivity
                startActivity(intent);
            }
        });
    }
}





