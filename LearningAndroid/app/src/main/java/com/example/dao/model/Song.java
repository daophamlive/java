package com.example.dao.model;

/**
 * Created by dao on 2/25/18.
 */

public class Song {
    private int id;
    private String name;
    private String singer;
    private boolean favorite = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Song(int id, String name, String singer, boolean favorite) {

        this.id = id;
        this.name = name;
        this.singer = singer;
        this.favorite = favorite;
    }
}
