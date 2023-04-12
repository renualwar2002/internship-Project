package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
Button about,academics,contact;
TextView nameTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		String dob = intent.getStringExtra("dob");
		String id = intent.getStringExtra("id");
		String college = intent.getStringExtra("college");
		String std = intent.getStringExtra("standard");
		String address = intent.getStringExtra("address");
		String email = intent.getStringExtra("email");
		String mobile = intent.getStringExtra("mobile");
		ConstraintLayout banner = findViewById(R.id.bannerLayout);
		nameTxt = banner.findViewById(R.id.name);
		nameTxt.setText(name);
		about = findViewById(R.id.about);
		academics = findViewById(R.id.academics);
		contact = findViewById(R.id.contact);
		about.setOnClickListener(view ->{
			Intent aboutIntent = new Intent(this,AboutActivity.class);
			aboutIntent.putExtra("name",name);
			aboutIntent.putExtra("id",id);
			aboutIntent.putExtra("dob",dob);
			startActivity(aboutIntent);
		});
		academics.setOnClickListener(view ->{
			Intent academicsIntent = new Intent(this,AcademicsActivity.class);
			academicsIntent.putExtra("name",name);
			academicsIntent.putExtra("college",college);
			academicsIntent.putExtra("std",std);
			startActivity(academicsIntent);
		});
		contact.setOnClickListener(view ->{
			Intent contactIntent = new Intent(this,ContactActivity.class);
			contactIntent.putExtra("name",name);
			contactIntent.putExtra("email",email);
			contactIntent.putExtra("mobile",mobile);
			contactIntent.putExtra("address",address);
			startActivity(contactIntent);
		});
	}
}