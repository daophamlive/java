package com.example.dao.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.dao.adapter.ImageAdapter;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

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

    private void addControls() {
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

    public void onBackToMainActivity(View view) {
        Intent intent = null;
        Log.d(MainActivity.LOG_TAG, "Button GridView back to main clicked!");
        intent = new Intent(GridViewActivity.this, MainActivity.class);
        if (intent != null)
            startActivity(intent);
        finish();
    }
}
