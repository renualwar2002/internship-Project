package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.internship.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    List<String> listViewValues;
    ArrayList<String> listviewdetails = new ArrayList<>();
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.mobile_list);

        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            jsonArray = jsonObject.getJSONArray("studentdetails");

            listViewValues = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                listViewValues.add(name);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.displayname, listViewValues);
            listview.setAdapter(adapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    try {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String name = obj.getString("name");
                        String age = obj.getString("age");
                        String address = obj.getString("address");
                        String email = obj.getString("email");

                        Intent intent = new Intent(MainActivity.this, StudentDetailsActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("age", age);
                        intent.putExtra("address", address);
                        intent.putExtra("email", email);
                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String loadJsonFile() throws IOException {
        String json = null;
        InputStream inputStream = this.getAssets().open("studentdetails.json");
        int size = inputStream.available();
        byte[] byteArray = new byte[size];
        inputStream.read(byteArray);
        inputStream.close();
        json = new String(byteArray, "UTF-8");
        return json;
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
