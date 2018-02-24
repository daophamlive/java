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

import com.example.dao.adapter.ContactAdapter;
import com.example.dao.model.Contact;

import java.util.ArrayList;

public class ListviewAdvancedActivity extends AppCompatActivity {

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

    public void onBackToMainActivity(View view) {
        Intent intent = null;
        Log.d(MainActivity.LOG_TAG, "Button Call_TextActivity clicked!");
        intent = new Intent(ListviewAdvancedActivity.this, MainActivity.class);
        if (intent != null)
            startActivity(intent);
        finish();
    }
}
