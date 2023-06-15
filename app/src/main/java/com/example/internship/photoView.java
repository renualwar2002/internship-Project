package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class photoView extends AppCompatActivity {

    private TextView nameTextView;
    private Button aboutButton, academicButton, contactButton, mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        ImageView imageView = findViewById(R.id.imageView);
        TextView detailsTextView = findViewById(R.id.txt_down);
        nameTextView = findViewById(R.id.txt_up);
        aboutButton = findViewById(R.id.button1);
        academicButton = findViewById(R.id.button2);
        contactButton = findViewById(R.id.button3);
        mainButton = findViewById(R.id.button4);

        String detailsString = getIntent().getStringExtra("details");

        if (detailsString == null) {
            Toast.makeText(this, "You will be redirected to Main Page", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            try {
                JSONObject jsonObject = new JSONObject(detailsString);

                String name = jsonObject.getString("name");
                String naanmudhalvanid = jsonObject.getString("naanmudhalvanid");
                String collegename = jsonObject.getString("collegename");
                String standard = jsonObject.getString("standard");
                String age = jsonObject.getString("age");
                String dob = jsonObject.getString("dob");
                String address = jsonObject.getString("address");
                String mobilenumber = jsonObject.getString("mobilenumber");

                nameTextView.setText(name);
                String formattedDetails = String.format(Locale.getDefault(), "Name: %s\n\nAge: %s\n\nDOB: %s", name, age, dob);
                aboutButton.setOnClickListener(v -> startNewActivity(About.class, formattedDetails));
                String formattedDetails2 = String.format(Locale.getDefault(), "Naan mudhalvan ID: %s\n\nStandard: %s\n\nCollege name: %s", naanmudhalvanid, standard, collegename);
                academicButton.setOnClickListener(v -> startNewActivity(academic.class, formattedDetails2));
                String formattedDetails3 = String.format(Locale.getDefault(), "Name: %s\n\nAddress: %s\n\nMobile number: %s", name, address, mobilenumber);
                contactButton.setOnClickListener(v -> startNewActivity(Contact.class, formattedDetails3));
                mainButton.setOnClickListener(view -> {
                    Intent intent = new Intent(photoView.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void startNewActivity(Class<?> cls, String formattedDetails) {
        Intent intent = new Intent(getApplicationContext(), cls);
        intent.putExtra("message_key", formattedDetails);
        startActivity(intent);
    }
}
