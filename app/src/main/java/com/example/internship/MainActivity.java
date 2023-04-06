package com.example.internship;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;
public class MainActivity extends AppCompatActivity {

    ListView listview;
    List<String> listViewValues;
    ArrayList<String> listviewdetails = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.mobile_list);

        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");
            listViewValues = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                listViewValues.add(name);
            }
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.displayname, listViewValues);
            listview.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String item = adapterView.getItemAtPosition(i).toString();
                intent.putExtra("name", item);
                startActivity(intent);
                Toast.makeText(MainActivity.this, item + " clicked", Toast.LENGTH_SHORT).show();
                // intent=new Intent(MainActivity.this,MainActivity3.class);
                // item = adapterView.getItemAtPosition(i).toString();
                //intent.putExtra("name",item);
                // startActivity(intent);

            }
        });
    }
            //listview.setOnItemClickListener(new OnItemClickListener() {

                //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  //  Toast.makeText(getApplicationContext(), ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                   // Toast.makeText(MainActivity.this, "you clicked" +listviewdetails.get(position), Toast.LENGTH_SHORT).show();
              //  }
           // });

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