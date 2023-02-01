package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Review;
import com.example.Allegra.Repositories.AuctionRepository;
import com.example.Allegra.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewRepository repository;
    @Autowired
    AuctionRepository auctionRepository;

    @GetMapping("/{id}")
    public Iterable<Review> getReviewsByAuctionId(@PathVariable("id") Long id){
        return repository.findByAuctionId(id);
    }
    @GetMapping("/delete/{id}")
    public void getDeletion(@PathVariable("id") Long id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/api/reviews/delete/"+id);
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        repository.deleteById(id);
    }


}
