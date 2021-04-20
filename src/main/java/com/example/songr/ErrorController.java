package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ErrorController {

    @GetMapping("/error/{errorMessage}")
    public String showErrorPage(Model m, @PathVariable String errorMessage){
        m.addAttribute("errorMessage",errorMessage);
        return "error";
    }
}
