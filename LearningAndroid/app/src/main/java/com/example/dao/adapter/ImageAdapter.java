package com.example.dao.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.dao.learningandroid.R;

import java.util.List;

/**
 * Created by dao on 2/24/18.
 */

public class ImageAdapter extends ArrayAdapter <Integer> {

    Activity context;
    int resource;
    List<Integer> objects;
    public ImageAdapter(@NonNull Activity context, int resource, @NonNull List<Integer> objects) {
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

        ImageView imageView = (ImageView) row.findViewById(R.id.imageView_GridView);

        imageView.setImageResource(this.objects.get(position));

        return row;
    }
}
