package com.example.dao.learningandroid;

import android.app.Activity;
import android.content.Intent;
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
import java.util.List;

public class KaraokeActivity extends Activity {

    final String SONG_TAB = "song";
    final String FAVORITE_TAB = "favorite";

    private TabHost mTabHost;

    private ArrayList<Song> songs = new ArrayList<>();
    private SongAdapter songAdapter;
    private ListView listViewSong;

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
        songs.add(new Song(123, "yeu em dai lau", "le hieu", true));
        songs.add(new Song(456, "yeu em dai lau1", "le hieu1", false));
        songs.add(new Song(7698, "yeu em dai lau2", "le hieu2", true));
        songs.add(new Song(23656, "yeu em dai lau3", "le hieu3", false));
        songs.add(new Song(3676, "yeu em dai lau4", "le hieu4", false));
        songs.add(new Song(567, "yeu em dai lau5", "le hieu5", false));
        songAdapter = new SongAdapter(this, R.layout.song_item, songs);
        listViewSong.setAdapter(songAdapter);
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
        if(tabid.equalsIgnoreCase(SONG_TAB))
        {
            if(linearLayoutFavoritSong != null)
                linearLayoutFavoritSong.removeView(listViewSong);
            linearLayoutSong.addView(listViewSong);
            songAdapter.setShowFavoriteOnly(false);
        }
        else if(tabid.equalsIgnoreCase(FAVORITE_TAB))
        {
            if(linearLayoutSong != null)
                linearLayoutSong.removeView(listViewSong);
            linearLayoutFavoritSong.addView(listViewSong);
            songAdapter.setShowFavoriteOnly(true);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

}