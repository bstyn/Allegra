package com.example.Allegra.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/auctions")
    public String auctions(){
        return "auctions";
    }

    @GetMapping("/auctions/{id}")
    public String auction(@PathVariable("id") String id){
        return "auction";
    }
}
