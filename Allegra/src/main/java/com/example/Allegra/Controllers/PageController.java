package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Auction;
import com.example.Allegra.Repositories.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public String auctions(Model model){

        final String uri = "http://localhost:8080/api/auctions";

        RestTemplate restTemplate = new RestTemplate();
        Iterable<Auction> result = restTemplate.getForObject(uri,Iterable.class);
        model.addAttribute("auctions",result);
        return "auctions";
    }

    @GetMapping("/auctions/{id}")
    public String auction(@PathVariable("id") String id){
        return "auction";
    }
}
