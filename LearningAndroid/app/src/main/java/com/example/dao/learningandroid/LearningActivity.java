package com.example.dao.learningandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.dao.model.Song;

public class LearningActivity extends Activity {

    EditText txtSend2Activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        addControls();
    }

    private void addControls() {
        txtSend2Activity = (EditText) findViewById(R.id.txtSend2Activity);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public void onCallNewActivity(View view) {
        Intent myIntent = new Intent(LearningActivity.this, Learning2Activity.class);

        float value = Float.valueOf(txtSend2Activity.getText().toString());
        myIntent.putExtra("KieuFloat", value);

        Song song = new Song(1,"Bai hat", "ca si", false);

        Bundle bundle = new Bundle();
        Song song1 = new Song(2,"Bai hat 2", "ca si 2", false);
        bundle.putSerializable("song",song1);

        myIntent.putExtra("SONG",song);
        myIntent.putExtra("Bundle", bundle);
        startActivity(myIntent);
        //startActivityForResult(myIntent, 0);
    }
}
