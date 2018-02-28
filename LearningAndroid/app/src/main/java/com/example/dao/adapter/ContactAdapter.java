package com.example.dao.adapter;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dao.learningandroid.R;
import com.example.dao.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dao on 2/22/18.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    Activity context;
    int resource;
    ArrayList<Contact> objects;

    public ContactAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //hiển thị trên một row của
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView textViewName = (TextView)row.findViewById(R.id.textViewName);
        TextView textViewMobile = (TextView)row.findViewById(R.id.textViewMobile);
        ImageButton btnCall = (ImageButton) row.findViewById(R.id.btnCall);
        ImageButton btnMessage = (ImageButton) row.findViewById(R.id.btnMessage);
        ImageButton btnDetail = (ImageButton) row.findViewById(R.id.btnDetail);

        final Contact contact = this.objects.get(position);

        textViewName.setText(contact.getName());
        textViewMobile.setText(contact.getPhone());


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processAction(contact);
            }
        });

        return row;
    }

    private void processAction(Contact contact) {

        Toast.makeText(this.context, contact.getName().toString(), Toast.LENGTH_SHORT).show();
    }
}
