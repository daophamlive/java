package com.example.dao.learningandroid;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.dao.adapter.ImageAdapter;

import java.util.ArrayList;

public class GridViewActivity extends Activity {

    GridView gridView;
    ImageAdapter adapter;
    ArrayList<Integer> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        addControls();
        addEvents();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
    private void addControls() {
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gridView = (GridView) findViewById(R.id.gridView);
        arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bitcoin);
        arrayList.add(R.drawable.coin_icon);
        arrayList.add(R.drawable.diamond);
        arrayList.add(R.drawable.gold);
//        arrayList.add(R.drawable.ic_launcher_background);
//        arrayList.add(R.drawable.ic_launcher_foreground);

        adapter = new ImageAdapter(GridViewActivity.this,
                R.layout.gridview_item,
                arrayList);
        gridView.setAdapter(adapter);
    }

    private void addEvents() {

    }

}
