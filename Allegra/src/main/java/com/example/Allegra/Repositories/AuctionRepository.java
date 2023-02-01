package com.example.Allegra.Repositories;

import com.example.Allegra.Models.Auction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuctionRepository extends CrudRepository<Auction, Long> {

    Optional<Auction> findById(Long id);

    Iterable<Auction> findAll();

    void deleteById(Long id);
}
