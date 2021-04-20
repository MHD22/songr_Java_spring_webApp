package com.example.songr;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;


    // Requests for JSON format:

    @JsonView(Views.Public.class)
    @PostMapping("/addSong2")
    public ResponseEntity<Song> addSong(String title, int length, int trackNumber, long albumId){
        Album album = albumRepository.findById(albumId).get();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);
        return new ResponseEntity(song, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @GetMapping("/songs2")
    public ResponseEntity<Song> returnAllSongsAsJSON(){
        List<Song> songs= songRepository.findAll();

        return new ResponseEntity(songs,HttpStatus.OK);
    }


    //______________________________
    // Requests for HTML templates:
    //______________________________

    @GetMapping("/addSong")
    public String viewAddSongForm(){
        return "addSong";
    }

    @PostMapping("/addSong")
    public RedirectView addSongToDB(Model m, String title, int length, long albumId)
    {
        if(length <= 0)
            return new RedirectView("error/length and track can't be negative number or zero");
        try{

            Album album = albumRepository.findById(albumId).get();//try
            album.setLength(album.getLength()+ length);
            album.setSongCount(album.getSongCount()+1);
            int trackNumber = album.getSongCount();
            albumRepository.save(album);
            Song song = new Song(title, length,trackNumber,album);
            songRepository.save(song);

            return new RedirectView("songs");
        }
        catch(Exception e){
            return new RedirectView("error/album ID is not defined..");
        }
    }

    @GetMapping("/songs")
    public String showAllSongs(Model m){
        List<Song> songs= songRepository.findAll();
        m.addAttribute("songs",songs);

        return "songs";
    }



}
