package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    @GetMapping("/albums")
    public String getThreeAlbums(Model m){
        Album album1 = new Album("A7la w a7la", "Amr Diab",6,1440,"https://i.ytimg.com/vi/8IJIP1OUbMM/maxresdefault.jpg");
        Album album2 = new Album("pain", "Ryan Jones",8,1870,"https://d1csarkz8obe9u.cloudfront.net/posterpreviews/artistic-album-cover-design-template-d12ef0296af80b58363dc0deef077ecc_screen.jpg?ts=1561488440");
        Album album3 = new Album("new Album", "Rihana",5,1200,"https://d16kd6gzalkogb.cloudfront.net/magazine_images/Rihanna-New-Cover-Art-3.jpg");
        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        m.addAttribute("albums",albums);

        return "albums";
    }
}
