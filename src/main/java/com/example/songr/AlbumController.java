package com.example.songr;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAlbums(Model m){ // return albums in template
        List<Album> albums = (List<Album>) albumRepository.findAll();
        m.addAttribute("albums",albums);
        return "albums";
    }
    @GetMapping("/albums/{id}")
    public String getSpecificAlbums(Model m ,@PathVariable long id){ // return albums in template

       try{
               Album album =  albumRepository.findById(id).get();
               List<Album> albums = new ArrayList<>();
               albums.add(album);
               m.addAttribute("albums",albums);
               return "albums";
        }
       catch (Exception e){
           String error = "Album ID is Not found..!";
           m.addAttribute("errorMessage",error);
           return "error";
       }

    }



    @GetMapping("/addAlbum")
    public String viewAddAlbumForm(){
        return "addAlbum";
    }


    @PostMapping("/addAlbum")
    public RedirectView addAlbumToDB(Model m, String title, String artist, String imageUrl){

        Album album = new Album(title,artist,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/albumsALL")
    public ResponseEntity<Album> getAlbums(){ // return albums as json
        List<Album> albums = albumRepository.findAll();
        return new ResponseEntity(albums, HttpStatus.OK);
    }
}
