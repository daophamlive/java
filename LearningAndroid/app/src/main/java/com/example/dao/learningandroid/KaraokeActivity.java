package com.example.dao.learningandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.dao.adapter.SongAdapter;
import com.example.dao.model.ObjectStringConvertion;
import com.example.dao.model.Song;

import java.io.IOException;
import java.util.ArrayList;

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

        try {
            addControls();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addEvents();
    }

    private void addEvents() {
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                try {
                    showTab(tabId);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initSongs() {
        for (int i =0; i < 100000; i ++)
        {
            Song song = new Song(i, "yeu em dai lau" + String.valueOf(i), "le hieu " + String.valueOf(i) , false);
            songs.add(song);
        }
        songAdapter = new SongAdapter(this, R.layout.song_item, songs);
        listViewSong.setAdapter(songAdapter);
    }

    private void addControls() throws IOException {

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
        showTab(SONG_TAB);
    }

    public void showTab(String tabid) throws IOException {
        FrameLayout frameLayout = mTabHost.getTabContentView();
        LinearLayout linearLayoutSong = (LinearLayout) frameLayout.findViewById(R.id.songTab);
        LinearLayout linearLayoutFavoritSong = (LinearLayout) frameLayout.findViewById(R.id.favouriteTab);

        if(tabid.equalsIgnoreCase(SONG_TAB))
        {
            if(linearLayoutFavoritSong != null)
                linearLayoutFavoritSong.removeView(listViewSong);

            linearLayoutSong.addView(listViewSong);

            songAdapter.getFilter().filter("");
            songAdapter.notifyDataSetChanged();
        }
        else if(tabid.equalsIgnoreCase(FAVORITE_TAB)){

            if(linearLayoutSong != null)
                linearLayoutSong.removeView(listViewSong);

            linearLayoutFavoritSong.addView(listViewSong);
            Song filterSong = new Song();
            filterSong.setFavorite(true);
            CharSequence filter = ObjectStringConvertion.convertObjectToString(filterSong);
            songAdapter.getFilter().filter(filter);
            songAdapter.notifyDataSetChanged();
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

}