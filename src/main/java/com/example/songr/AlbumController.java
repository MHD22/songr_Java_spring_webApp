package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getThreeAlbums(Model m){
        List<Album> albums = (List<Album>) albumRepository.findAll();
        m.addAttribute("albums",albums);
        return "albums";
    }
    @GetMapping("/addAlbum")
    public String viewAddAlbumForm(){
        return "addAlbum";
    }
    @PostMapping("/addAlbum")
    public RedirectView addAlbumToDB(Model m,
                                     @RequestParam(value="title") String title,
                                     @RequestParam(value="artist") String artist,
                                     @RequestParam(value="songCount") int songCount,
                                     @RequestParam(value="length") int length,
                                     @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

}
