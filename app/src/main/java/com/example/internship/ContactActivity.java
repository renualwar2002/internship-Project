package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		ConstraintLayout banner = findViewById(R.id.bannerLayout);
		TextView nameTxt = banner.findViewById(R.id.name);
		nameTxt.setText(String.format("About %s", getIntent().getStringExtra("name")));
		TextView email = findViewById(R.id.email);
		email.setText(getIntent().getStringExtra("email"));
		TextView mobile = findViewById(R.id.mobile);
		mobile.setText(getIntent().getStringExtra("mobile"));
		TextView address = findViewById(R.id.address);
		address.setText(getIntent().getStringExtra("address"));
	}
}