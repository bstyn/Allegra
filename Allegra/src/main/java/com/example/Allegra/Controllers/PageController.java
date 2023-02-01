package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Auction;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Repositories.AuctionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class PageController {

    @Getter @Setter private Long profileId = 1L;


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        RestTemplate restTemplate = new RestTemplate();
        Profile result = restTemplate.getForObject("http://localhost:8080/api/profiles/" + profileId,Profile.class);
        model.addAttribute("profile",result);
        return "profile";
    }

    @GetMapping("/auctions")
    public String auctions(Model model){

        RestTemplate restTemplate = new RestTemplate();
        Iterable<Auction> result = restTemplate.getForObject("http://localhost:8080/api/auctions",Iterable.class);
        model.addAttribute("auctions",result);
        return "auctions";
    }

    @GetMapping("/auctions/{id}")
    public String auction(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();
        Auction result = restTemplate.getForObject("http://localhost:8080/api/auctions/" + id,Auction.class);
        model.addAttribute("auction",result);
        return "auction";
    }
}
