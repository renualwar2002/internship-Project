package com.example.internship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity4 extends AppCompatActivity {

    Button buttonxml4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        buttonxml4 = findViewById(R.id.buttonofxml4);

        // Set an OnClickListener to the button
        buttonxml4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                // Start the MainActivity
                startActivity(intent);

            }
        });
    }
}