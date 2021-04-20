package com.example.songr;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @JsonView({Views.Internal.class, Views.Public.class})
    private long id;

    @JsonView({Views.Internal.class, Views.Public.class})
    private String title;

    @JsonView({Views.Internal.class, Views.Public.class})
    private String artist;

    @JsonView({Views.Internal.class, Views.Public.class})
    private int songCount;

    @JsonView({Views.Internal.class, Views.Public.class})
    private int length;

    @JsonView({Views.Internal.class, Views.Public.class})
    private String imageUrl;

    @JsonView(Views.Internal.class)
    @OneToMany(mappedBy="album",cascade = CascadeType.ALL)
    List<Song> songs;

    public Album(String title, String artist, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = 0;
        this.length = 0;
        this.imageUrl = imageUrl;
    }

    public List<Song> getSongs() {
        return songs;
    }

    protected Album() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", length=" + length +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
