package com.example.Allegra.Services;

import com.example.Allegra.Models.Auction;
import com.example.Allegra.Repositories.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    @Autowired
    private final AuctionRepository auctionRepository;

    public Iterable<Auction> findAll(){
        return auctionRepository.findAll();
    }

}
