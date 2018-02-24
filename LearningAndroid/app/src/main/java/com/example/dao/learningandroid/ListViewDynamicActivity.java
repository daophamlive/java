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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dao.model.Person;

import java.util.ArrayList;

public class ListViewDynamicActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Person> arrayPersons;
    ArrayAdapter<Person> adapterPerson;

    Spinner spinnerLocation;
    String [] arrLocation;
    ArrayAdapter<String> adapterLocation;
    String selectedLocaton = "Ha Noi";

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

        arrayPersons = new ArrayList<Person>();
        adapterPerson = new ArrayAdapter<Person>(ListViewDynamicActivity.this,
                                android.R.layout.simple_list_item_1,
                arrayPersons);
        listView.setAdapter(adapterPerson);

        //for spinner
        spinnerLocation = (Spinner) findViewById(R.id.spinnerLocaton);
        arrLocation = getResources().getStringArray(R.array.arrLocation);
        adapterLocation = new ArrayAdapter<String>(ListViewDynamicActivity.this,
                android.R.layout.simple_spinner_item,
                arrLocation);
        adapterLocation.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerLocation.setAdapter(adapterLocation);
    }

    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewDynamicActivity.this, "Ban chon thu " + arrayPersons.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLocaton = arrLocation[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void onBtnAddName(View view) {
        arrayPersons.add(new Person(txtName.getText().toString(), selectedLocaton));
        adapterPerson.notifyDataSetChanged();
        txtName.setText("");
        txtName.requestFocus();
    }

    public void onBackToMainActivity(View view) {

        Intent intent = null;
        Log.d(MainActivity.LOG_TAG, "Button ListViewDynamicActivity back to main clicked!");
        intent = new Intent(ListViewDynamicActivity.this, MainActivity.class);
        if (intent != null)
            startActivity(intent);
        finish();
    }
}
