package com.example.dao.learningandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dao.model.Song;

public class Learning2Activity extends Activity {

    TextView txtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning2);
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        txtData = (TextView) findViewById(R.id.txtReceivedData);

        Intent intent = getIntent();
        float number = intent.getFloatExtra("KieuFloat", 0.1f);
        Song song = (Song) intent.getSerializableExtra("SONG");

        Bundle bundle = intent.getBundleExtra("Bundle");
        Song song1 = (Song) bundle.getSerializable("song");

        String s = "Song 1: " + song.toString() + " \n number = " + String.valueOf(number);
        s += "\n Song 2: " + song1.toString();
        txtData.setText(s);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), LearningActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}
