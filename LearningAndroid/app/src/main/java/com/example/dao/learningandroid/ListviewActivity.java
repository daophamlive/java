package com.example.dao.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {

    ListView listView;
    String [] arrDays;
    ArrayAdapter<String> adapterDays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        
        addControls();
        addEvents();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListviewActivity.this, "Ban chon thu " + arrDays[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        arrDays = getResources().getStringArray(R.array.arrDay);
        adapterDays = new ArrayAdapter<String>(
                            ListviewActivity.this,
                            android.R.layout.simple_list_item_1,
                            arrDays
                    );

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapterDays);

    }

}
