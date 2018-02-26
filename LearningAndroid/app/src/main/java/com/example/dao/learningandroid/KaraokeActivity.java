package com.example.dao.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

public class KaraokeActivity extends AppCompatActivity {

    TabHost mTabHost;
    ArrayList<Song> songs = new ArrayList<>();

    SongAdapter songAdapter;
    SongAdapter favoriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karaoke);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addControls();
        addEvents();
    }

    private void addEvents() {
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("favorite")) {
                    initFavoriteSongs();
                }
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
    }

    void initFavoriteSongs() {
        ArrayList<Song> favoriteSong = new ArrayList<>();
        favoriteSong.clear();
        for (Song song : songs) {
            if (song.isFavorite())
                favoriteSong.add(song);
        }
        if (favoriteAdapter != null) {
            favoriteAdapter.setObjects(favoriteSong);
            favoriteAdapter.notifyDataSetChanged();
        }
        else

            favoriteAdapter =new

                    SongAdapter(this,R.layout.song_item, favoriteSong);

    }
    private void addControls() {



        mTabHost = (TabHost) findViewById(R.id.tabhost);
        mTabHost.setup();
        FrameLayout frameLayout = mTabHost.getTabContentView();

        // Tab for Songs
        TabHost.TabSpec songTabSpec = mTabHost.newTabSpec("song");
        songTabSpec.setIndicator(getResources().getString(R.string.songs));
        songTabSpec.setContent(R.id.songTab);
        mTabHost.addTab(songTabSpec);
        //add listview to song tab
        LinearLayout linearLayoutSong = (LinearLayout) frameLayout.findViewById(R.id.songTab);
        ListView listViewSong = new ListView(mTabHost.getContext());
        initSongs();
        listViewSong.setAdapter(songAdapter);
        if (linearLayoutSong != null) {
            linearLayoutSong.addView(listViewSong);
        }

        // Tab for favorite Songs
        TabHost.TabSpec favoriteTabSpec = mTabHost.newTabSpec("favorite");
        favoriteTabSpec.setIndicator(getResources().getString(R.string.favourite_song));
        favoriteTabSpec.setContent(R.id.favouriteTab);
        mTabHost.addTab(favoriteTabSpec);

        //add listview to favorite tab
        LinearLayout linearLayoutFavorite = (LinearLayout) frameLayout.findViewById(R.id.favouriteTab);
        ListView listViewFavorite = new ListView(mTabHost.getContext());
        initFavoriteSongs();
        listViewFavorite.setAdapter(favoriteAdapter);
        if (linearLayoutFavorite != null) {
            linearLayoutFavorite.addView(listViewFavorite);
        }

    }



    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }


    View.OnClickListener myOnlyhandler = new View.OnClickListener() {
        public void onClick(View v) {

        }
    };
}