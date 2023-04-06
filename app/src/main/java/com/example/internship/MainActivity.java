package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    List<String> listViewValues;
    ArrayList<String> listviewdetails = new ArrayList<>();
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=(ListView) findViewById(R.id.mobile_list);

        try {
            JSONObject jsonObject=new JSONObject(loadJsonFile());
            JSONArray jsonArray=jsonObject.getJSONArray("studentdetails");
            listViewValues = new ArrayList<String>();
//            HashMap<String,String> list;
//            ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
            for(int i=0; i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String name=obj.getString("name");
                String email=obj.getString("email");
//                list=new HashMap<>();
//                list.put("email",email);
////                list.put("name",name);
                listViewValues.add(name);
//                listViewValues.add(email);
//                arrayList.add(list);
            }
//            ListAdapter adapter1=new SimpleAdapter(this,arrayList,R.layout.displayname, new String[]{"name"},
//                    new int[]{R.id.profileName});
//            listview.setAdapter(adapter1);
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.displayname, listViewValues);
            listview.setAdapter(adapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String item = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(MainActivity.this,
                            item+" clicked",Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(i==0){
                    Intent intent=new Intent(MainActivity.this,Profile.class);
//                    Intent intentAbout=new Intent(MainActivity.this,About.class);
                    String item = adapterView.getItemAtPosition(i).toString();
//                    String password = adapterView.getItemAtPosition(i).toString();
                    intent.putExtra("name",item);
//                    intentAbout.putExtra("email", email);
                    startActivity(intent);
//                    startActivity(intentAbout);
//                }
//                else if(i==1){
//                    Intent intent=new Intent(MainActivity.this,Profile2.class);
//                    String item = adapterView.getItemAtPosition(i).toString();
//                    intent.putExtra("name",item);
//                    startActivity(intent);
//                }
            }
        });

    }


    public String loadJsonFile() throws IOException {
        String json=null;
        InputStream inputStream=this.getAssets().open("studentdetails.json");
        int size=inputStream.available();
        byte[] byteArray=new byte[size];
        inputStream.read(byteArray);
        inputStream.close();
        json=new String(byteArray, "UTF-8");
        return json;
    }
}