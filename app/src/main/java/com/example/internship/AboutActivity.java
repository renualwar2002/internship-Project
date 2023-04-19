package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		ConstraintLayout banner = findViewById(R.id.bannerLayout);
		TextView nameTxt = banner.findViewById(R.id.name);
		nameTxt.setText(String.format("About %s", getIntent().getStringExtra("name")));
		TextView name = findViewById(R.id.nameStu);
		name.setText(getIntent().getStringExtra("name"));
		TextView id = findViewById(R.id.id);
		id.setText(getIntent().getStringExtra("id"));
		TextView dob = findViewById(R.id.dob);
		dob.setText(getIntent().getStringExtra("dob"));
		LinearLayout footer = findViewById(R.id.footerLayout);
		TextView back = footer.findViewById(R.id.back);
		back.setOnClickListener(view -> finish());
	}
}