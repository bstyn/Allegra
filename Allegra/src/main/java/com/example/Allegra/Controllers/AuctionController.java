package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Auction;
import com.example.Allegra.Repositories.AuctionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
