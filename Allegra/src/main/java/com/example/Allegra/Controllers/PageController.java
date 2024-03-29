package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Auction;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Models.Review;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class PageController {

    @Getter @Setter private static Long profileId;

    public static void setId(Long profileId) {
        setProfileId(profileId);
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        if(profileId == null){
            return "redirect:/login";
        }
        RestTemplate restTemplate = new RestTemplate();
        Profile result = restTemplate.getForObject("http://localhost:8080/api/profiles/get/" + profileId.toString(),Profile.class);
        model.addAttribute("profile",result);
        return "profile";
    }

    @GetMapping("/profile/edit")
    public String profileEdit(Model model){
        if(profileId == null){
            return "redirect:/login";
        }
        RestTemplate restTemplate = new RestTemplate();
        Profile result = restTemplate.getForObject("http://localhost:8080/api/profiles/get/" + profileId.toString(),Profile.class);
        model.addAttribute("profile",result);
        return "editProfile";
    }
    @GetMapping("/review/edit/{id}")
    public String reviewEdit(@PathVariable("id") Long id,Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Review result = restTemplate.getForObject("http://localhost:8080/api/reviews/review/" + id, Review.class);
        model.addAttribute("review", result);
        return "editReview";
    }
    @GetMapping("/auction/add")
    public String addAuction(){
        if(profileId == null){
            return "redirect:/login";
        }
        return "addAuction";
    }
    @GetMapping("/auction/edit/{id}")
    public String auctionEdit(@PathVariable("id") Long id,Model model){
        RestTemplate restTemplate = new RestTemplate();
        Auction auction = restTemplate.getForObject("http://localhost:8080/api/auctions/" + id, Auction.class);
        model.addAttribute("auction", auction);
        return "editAuction";
    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @GetMapping("/signup")
    public String Signup(Model model){
        return"signup";
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
        Iterable<Review> reviews = restTemplate.getForObject("http://localhost:8080/api/reviews/"+ id,Iterable.class);
        model.addAttribute("reviews",reviews);
        return "auction";
    }
}
