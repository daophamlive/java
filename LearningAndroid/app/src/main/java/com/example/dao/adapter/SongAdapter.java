package com.example.dao.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dao.learningandroid.R;
import com.example.dao.model.Song;

import java.util.List;

/**
 * Created by dao on 2/25/18.
 */


public class SongAdapter extends ArrayAdapter<Song> {
    Activity context;
    int resource;

    public List<Song> getObjects() {
        return objects;
    }

    public void setObjects(List<Song> objects) {
        this.objects = objects;
    }

    List<Song> objects;

    public SongAdapter(@NonNull Activity context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //hiển thị trên một row của
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtSongId = (TextView)row.findViewById(R.id.txtSongID);
        TextView txtSongName = (TextView)row.findViewById(R.id.txtSongName);
        TextView txtSinger = (TextView)row.findViewById(R.id.txtSinger);
        ImageButton btnFavorite = (ImageButton) row.findViewById(R.id.btnFavorite);

        final Song song = this.objects.get(position);

        txtSongId.setText(String.valueOf(song.getId()));
        txtSongName.setText(song.getName());
        txtSinger.setText(song.getSinger());

        if(song.isFavorite())
        {
            btnFavorite.setImageResource(R.drawable.favorite);
        }
        else
        {
            btnFavorite.setImageResource(R.drawable.unfavorite);
        }

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Song newSong = objects.get(position);
                newSong.setFavorite(!song.isFavorite());
                objects.set(position, newSong);
                notifyDataSetChanged();
            }
        });

        return row;
    }
}
