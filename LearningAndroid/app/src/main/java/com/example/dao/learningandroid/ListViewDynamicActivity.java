package com.example.dao.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewDynamicActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayListNames;
    ArrayAdapter<String> adapterNames;

    EditText txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_dynamic);
        addControls();
        addEvents();
    }

    private void addControls() {
        listView = (ListView) findViewById(R.id.listView);
        txtName = (EditText) findViewById(R.id.txtName);

        arrayListNames = new ArrayList<String>();
        adapterNames = new ArrayAdapter<String>(ListViewDynamicActivity.this,
                                android.R.layout.simple_list_item_1,
                                arrayListNames);
        listView.setAdapter(adapterNames);
    }

    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewDynamicActivity.this, "Ban chon thu " + arrayListNames.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onBackToMainActivity(View view) {

        Intent intent = null;
        Log.d(MainActivity.LOG_TAG, "Button ListViewDynamicActivity back to main clicked!");
        intent = new Intent(ListViewDynamicActivity.this, MainActivity.class);
        if (intent != null)
            startActivity(intent);
        finish();
    }

    public void onBtnAddName(View view) {
        arrayListNames.add(txtName.getText().toString());
        adapterNames.notifyDataSetChanged();
        txtName.setText("");
        txtName.requestFocus();
    }
}
