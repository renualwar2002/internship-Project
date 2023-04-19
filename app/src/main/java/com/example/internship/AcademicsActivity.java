package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AcademicsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_academics);
		ConstraintLayout banner = findViewById(R.id.bannerLayout);
		TextView nameTxt = banner.findViewById(R.id.name);
		nameTxt.setText(String.format("About %s", getIntent().getStringExtra("name")));
		TextView college = findViewById(R.id.college);
		college.setText(getIntent().getStringExtra("college"));
		TextView standard = findViewById(R.id.standard);
		standard.setText(getIntent().getStringExtra("std"));
		LinearLayout footer = findViewById(R.id.footerLayout);
		TextView back = footer.findViewById(R.id.back);
		back.setOnClickListener(view -> finish());
	}
}