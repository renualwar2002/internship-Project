package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailsActivity extends AppCompatActivity {

    TextView tvName, tvAge, tvAddress, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        tvName = findViewById(R.id.student_name);
        tvAge = findViewById(R.id.student_email);
        tvAddress = findViewById(R.id.student_address);
        tvEmail = findViewById(R.id.student_phone);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String address = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");

        tvName.setText("Name: " + name);
        tvAge.setText("Age: " + age);
        tvAddress.setText("Address: " + address);
        tvEmail.setText("Email: " + email);
    }
}
