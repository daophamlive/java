package com.example.dao.learningandroid;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.dao.adapter.SongAdapter;
import com.example.dao.model.Song;

import java.util.ArrayList;

public class KaraokeActivity extends Activity {

    final String SONG_TAB = "song";
    final String FAVORITE_TAB = "favorite";

    private TabHost mTabHost;

    private ArrayList<Song> songs = new ArrayList<>();
    private ArrayList<Song> favorites = new ArrayList<>();
    private SongAdapter songAdapter;
    private SongAdapter favoriteAdapter;

    private ListView listViewSong;
    private ListView listViewFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karaoke);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addControls();
        addEvents();
    }

    private void addEvents() {
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                addListViewIntoTab(tabId);
            }
        });


    }

    private void initSongs() {
        for (int i =0; i < 1000; i ++)
        {
            Song song = new Song(i, "yeu em dai lau" + String.valueOf(i), "le hieu " + String.valueOf(i) , false);
            songs.add(song);

            if(song.isFavorite())
                favorites.add(song);
        }
        songAdapter = new SongAdapter(this, R.layout.song_item, songs);
        listViewSong.setAdapter(songAdapter);

        favoriteAdapter = new SongAdapter(this, R.layout.song_item, favorites);
        listViewFavorite.setAdapter(favoriteAdapter);

        songAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                list1.setSelection(adp.getCount()-1);
            }
        });

    }

    private void addControls() {

        mTabHost = (TabHost) findViewById(R.id.tabhost);
        mTabHost.setup();

        listViewSong = new ListView(mTabHost.getContext());

        // Tab for Songs
        TabHost.TabSpec songTabSpec = mTabHost.newTabSpec(SONG_TAB);
        songTabSpec.setIndicator(getResources().getString(R.string.songs));
        songTabSpec.setContent(R.id.songTab);
        mTabHost.addTab(songTabSpec);

        // Tab for favorite Songs
        TabHost.TabSpec favoriteTabSpec = mTabHost.newTabSpec(FAVORITE_TAB);
        favoriteTabSpec.setIndicator(getResources().getString(R.string.favourite_song));
        favoriteTabSpec.setContent(R.id.favouriteTab);
        mTabHost.addTab(favoriteTabSpec);

        initSongs();
        addListViewIntoTab(SONG_TAB);
    }

    public void addListViewIntoTab(String tabid)
    {
        FrameLayout frameLayout = mTabHost.getTabContentView();
        LinearLayout linearLayoutSong = (LinearLayout) frameLayout.findViewById(R.id.songTab);
        LinearLayout linearLayoutFavoritSong = (LinearLayout) frameLayout.findViewById(R.id.favouriteTab);
        linearLayoutSong.addView(listViewSong);
        linearLayoutFavoritSong.addView(listViewFavorite);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

}