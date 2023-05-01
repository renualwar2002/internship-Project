package com.example.internship;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    TextView textView,aboutMe;
    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        textView = findViewById(R.id.name);
        textView.setText(name);
        aboutMe = findViewById(R.id.about_me);
        backButton = findViewById(R.id.back_button);

        aboutMe.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, AboutMe.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        backButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}