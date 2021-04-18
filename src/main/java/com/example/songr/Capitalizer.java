package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Capitalizer {

    @GetMapping("/capitalize/{sentence}")
    public String capitalize(Model m,@PathVariable String sentence){
        String capitalized = sentence.toUpperCase();
        m.addAttribute("sentence",capitalized);

        return "capitalize";
    }
}
