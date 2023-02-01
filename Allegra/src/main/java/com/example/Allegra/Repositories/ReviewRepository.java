package com.example.Allegra.Repositories;

import com.example.Allegra.Models.Auction;
import com.example.Allegra.Models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review,Long> {

    Optional<Review> findById(Long id);
    @Query(value = "SELECT * FROM review WHERE auction_id = :#{#id}",nativeQuery = true)
    Iterable<Review> findByAuctionId(@Param("id") Long id);

    void deleteById(Long id);
}
