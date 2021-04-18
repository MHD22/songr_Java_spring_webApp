package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Tester {

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello.html";
    }
}
