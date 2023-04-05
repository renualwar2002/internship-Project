package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button contact,academic,about;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        contact=(Button) findViewById(R.id.contact);
        about=findViewById(R.id.about);
        academic=findViewById(R.id.academic);
        Intent intent=getIntent();
        String item = intent.getStringExtra("name");
        TextView result = findViewById(R.id.textView2);
        result.setText("About  "+item);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity2.this,About.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });
        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,Academic.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,Contact.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });
        //listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  @Override
          //  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //   Intent intent=new Intent(MainActivity2.this,About.class);
              //  String item = adapterView.getItemAtPosition(i).toString();
              //  intent.putExtra("name",name);
               intent.putExtra("name",item);
           // }
       // });
    }
}