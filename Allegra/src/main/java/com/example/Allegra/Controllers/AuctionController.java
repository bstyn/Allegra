package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Address;
import com.example.Allegra.Models.Auction;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Models.UserDTO;
import com.example.Allegra.Repositories.AuctionRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    private final AuctionRepository auctionRepository;

    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @GetMapping
    public Iterable<Auction> findAll(){
        return auctionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Auction> findById(@PathVariable("id") Long id){
        return auctionRepository.findById(id);
    }

    @PostMapping("/addAuction")
    public void addAuction(Auction auction,HttpServletResponse response) throws IOException {
        Auction newAuction = new Auction(auction.getName(),new Date(),auction.getEnd_date(),auction.getUrl(),auction.getPrice());
        auctionRepository.save(newAuction);
        response.sendRedirect("/auctions");
    }
    @GetMapping("/delete/{id}")
    public void getDeletion(@PathVariable("id") Long id,HttpServletResponse response) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/api/auctions/delete/"+id);
        response.sendRedirect("/auctions");
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        auctionRepository.deleteById(id);
        response.sendRedirect("/auctions");
    }
    @GetMapping("/edit/{id}")
    public void getEdit(@PathVariable("id") Long id,HttpServletResponse response,Auction auction) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/api/auctions/edit/"+id,auction);
        response.sendRedirect("/auctions");
    }
    @PutMapping("/edit/{id}")
    public void editById(@PathVariable("id") Long id,@RequestBody Auction auction){
        Optional<Auction> auction2  = auctionRepository.findById(id);
        Auction newAuction = auction2.get();
        newAuction.setName(auction.getName());
        newAuction.setUrl(auction.getUrl());
        newAuction.setPrice(auction.getPrice());
        newAuction.setEnd_date(auction.getEnd_date());
        newAuction.setStart_date(auction.getStart_date());
        auctionRepository.save(newAuction);



    }

}

