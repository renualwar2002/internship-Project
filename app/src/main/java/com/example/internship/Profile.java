package com.example.internship;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Profile extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.profile);
        Button about = (Button) findViewById(R.id.about);
        Button academics = (Button) findViewById(R.id.academics);
        Button contact = (Button) findViewById(R.id.contact);
        TextView profileName = (TextView) findViewById(R.id.profileName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        profileName.setText(name);
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, About.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        academics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, Academics.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, Contact.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



//        try {
//            JSONObject jsonObject=new JSONObject(loadJsonFile());
//            JSONArray jsonArray=jsonObject.getJSONArray("studentdetails");
////            listViewValues = new ArrayList<String>();
//            HashMap<String,String> list;
//            ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
//            for(int i=0; i<jsonArray.length();i++)
//            {
//                JSONObject obj=jsonArray.getJSONObject(i);
//                String mobno=obj.getString("mobilenumber");
//                String email=obj.getString("email");
//                list=new HashMap<>();
//                list.put("email",email);
//                list.put("mobno",mobno);
////                listViewValues.add(name);
////                listViewValues.add(email);
//                arrayList.add(list);
//            }
//            ListAdapter adapter1=new SimpleAdapter(this,arrayList,R.layout.displayname, new String[]{"name"},
//                    new int[]{R.id.profileName});
//            listview.setAdapter(adapter1);
////            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.displayname, listViewValues);
////            listview.setAdapter(adapter);
////
////            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////                @Override
////                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////
////                    String item = adapterView.getItemAtPosition(i).toString();
////                    Toast.makeText(Profile.this,
////                            item+" clicked",Toast.LENGTH_SHORT).show();
////                }
////            });
//        }
//        catch (JSONException | IOException e) {
//            e.printStackTrace();
//        }




//    public String loadJsonFile() throws IOException {
//        String json=null;
//        InputStream inputStream=this.getAssets().open("studentdetails.json");
//        int size=inputStream.available();
//        byte[] byteArray=new byte[size];
//        inputStream.read(byteArray);
//        inputStream.close();
//        json=new String(byteArray, "UTF-8");
//        return json;
//    }

