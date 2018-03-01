package com.example.dao.adapter;

import android.app.Activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.example.dao.learningandroid.R;
import com.example.dao.model.ObjectStringConvertion;
import com.example.dao.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by dao on 2/25/18.
 */

//tham khao them o day https://vshivam.wordpress.com/2015/01/07/hiding-a-list-item-from-an-android-listview-without-removing-it-from-the-data-source/
public class SongAdapter extends ArrayAdapter<Song> implements Filterable {
    Activity context;
    int resource;
    List<Song> objects;
    List<Song> filteredData;
    Filter mFilter;

    public SongAdapter(@NonNull Activity context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
        filteredData = new ArrayList<>();
        mFilter = new SongFilter();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //hiển thị trên một row của
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);
        Song song = getItem(position);

        TextView txtSongId = (TextView) row.findViewById(R.id.txtSongID);
        TextView txtSongName = (TextView) row.findViewById(R.id.txtSongName);
        TextView txtSinger = (TextView) row.findViewById(R.id.txtSinger);
        ImageButton btnFavorite = (ImageButton) row.findViewById(R.id.btnFavorite);
        txtSongId.setText(String.valueOf(song.getId()));
        txtSongName.setText(song.getName());
        txtSinger.setText(song.getSinger());

        if (song.isFavorite()) {
            btnFavorite.setImageResource(R.drawable.favorite);
        } else {
            btnFavorite.setImageResource(R.drawable.unfavorite);
        }

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processFavorite(position);
            }
        });

        return row;
    }

    private void processFavorite(int position) {
        Song newSong = getItem(position);
        newSong.setFavorite(!newSong.isFavorite());

        if(filteredData != null) {
            filteredData.remove(position);
            for (int i = 0; i < this.objects.size() ; i++) {
                if(this.objects.get(i).getId() == newSong.getId())
                {
                    this.objects.set(i,newSong);
                    break;
                }

            }
        }
        else
            this.objects.set(position, newSong);
        notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        if(filteredData != null)
            return filteredData.size();
        return this.objects.size();
    }

    @Nullable
    @Override
    public Song getItem(int position) {
        if(filteredData  != null)
            return filteredData.get(position);
        return this.objects.get(position);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class SongFilter extends Filter {

        private boolean checkSong(Song song, Song filterObject) {
            boolean canShow = false;

            if (filterObject != null) {
                if (filterObject.getName() != null ) {
                    canShow = song.getName().equalsIgnoreCase(song.getName());
                }

                if (filterObject.getSinger()!= null) {
                    canShow = song.getName().equalsIgnoreCase(song.getSinger());
                }

                if (filterObject.getId() != -1) {
                    canShow = filterObject.getId() == song.getId();
                }

                if (filterObject.isFavorite() != null) {
                    canShow = (filterObject.isFavorite().booleanValue() == song.isFavorite().booleanValue());
                }
            } else {
                canShow = true;
            }
            return canShow;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            Song filterObject = null;
            if(constraint.length() != 0)
            {
                filterObject = (Song) ObjectStringConvertion.convertStringToObject(constraint.toString());
            }

            FilterResults results = new FilterResults();
            if(filterObject != null) {
                final List<Song> list = objects;

                int count = list.size();
                ArrayList<Song> nlist = new ArrayList<Song>(count);

                Song object = null;

                for (int i = 0; i < count; i++) {
                    object = list.get(i);
                    if (checkSong(object, filterObject) == true) {
                        nlist.add(object);
                    }
                }

                results.values = nlist;
                results.count = nlist.size();
            }

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<Song>) results.values;
            notifyDataSetChanged();
        }

    }
}