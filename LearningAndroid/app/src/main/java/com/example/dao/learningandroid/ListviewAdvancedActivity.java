package com.example.dao.learningandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dao.adapter.ContactAdapter;
import com.example.dao.model.Contact;

import java.util.ArrayList;

public class ListviewAdvancedActivity extends Activity {

    ListView listView;
    ArrayList<Contact> arrayListContacts;
    ContactAdapter adapterContact;

    EditText txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_advanced);
        addControls();
        addEvents();
    }

    private void addControls() {
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (ListView) findViewById(R.id.listView);
        txtName = (EditText) findViewById(R.id.txtName);

        arrayListContacts = new ArrayList<Contact>();
        adapterContact = new ContactAdapter(ListviewAdvancedActivity.this,
                R.layout.advanced_listview_item,
                arrayListContacts);
        listView.setAdapter(adapterContact);
    }

    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListviewAdvancedActivity.this, "Ban chon " + arrayListContacts.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onBtnAddName(View view) {
        Contact contact = new Contact(1, txtName.getText().toString() , "07097800879");
        arrayListContacts.add(contact);
        adapterContact.notifyDataSetChanged();
        txtName.setText("");
        txtName.requestFocus();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}
