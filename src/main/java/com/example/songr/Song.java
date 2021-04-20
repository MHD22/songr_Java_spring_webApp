package com.example.songr;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonView({Views.Internal.class, Views.Public.class})
    long id;

    @JsonView({Views.Internal.class, Views.Public.class})
    String title;

    @JsonView({Views.Internal.class, Views.Public.class})
    int length;

    @JsonView({Views.Internal.class, Views.Public.class})
    int trackNumber;

    @JsonView(Views.Public.class)
    @ManyToOne
    Album album;

    public Song(String title, int length, int trackNumber, Album album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public Song() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getAlbum() {
        return album;
    }
}
