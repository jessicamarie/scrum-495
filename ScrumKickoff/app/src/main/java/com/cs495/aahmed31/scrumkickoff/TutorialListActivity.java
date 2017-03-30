package com.cs495.aahmed31.scrumkickoff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class TutorialListActivity extends AppCompatActivity {

    private ArrayList<HashMap<String,String>> tutorArray = new ArrayList<HashMap<String, String>>();
    ListView tutorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_list);

        tutorList = (ListView) findViewById(R.id.tutoorialslist);
        initList();
        tutorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String chosen = "" + tutorList.getItemAtPosition(position);
                Toast.makeText(TutorialListActivity.this, chosen, Toast.LENGTH_LONG).show();

                //Intent intent = new Intent(PersonList.this, PersonInfo.class);
                //startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initList(){
        String n = "tutorial_name", d = "tutorial_descrip", t = "time";

        tutorArray = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put(n, "Roles Tutorial");
        hm.put(d, "Learn the difference between Scrum Master and Developer Roles");
        hm.put(t, "5mins");
        tutorArray.add(hm);

        SimpleAdapter adapter = new SimpleAdapter(this,
                tutorArray,
                R.layout.simple_listbox,
                new String[]{n,t},
                new int[]{R.id.list_title_holder,R.id.list_time_holder});
        tutorList.setAdapter(adapter);
    }
}
