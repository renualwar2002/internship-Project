package com.example.internship;

import static com.example.internship.R.id.girl1;
import static com.example.internship.R.id.girl2;

import androidx.appcompat.app.AppCompatActivity;
import com.example.internship.MainActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {
Button showMap1;
    Button showMap2;
Button  showMap;
    ListView listview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showMap = findViewById(R.id.button1);
        showMap1 = findViewById(girl1);
        showMap2 = findViewById(girl2);
        Intent intent=getIntent();
        String item = intent.getStringExtra("name");
        TextView result = findViewById(R.id.textView2);
        result.setText(" "+item);
        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });

      showMap1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, academicessai.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });
        showMap2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, contectessai.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });
        intent.putExtra("name",item);
    }
}