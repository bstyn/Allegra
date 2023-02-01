package com.example.Allegra.Controllers;

import com.example.Allegra.Models.*;
import com.example.Allegra.Repositories.AuctionRepository;
import com.example.Allegra.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

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
    @GetMapping("/review/{id}")
    public Optional<Review> getReviewsId(@PathVariable("id") Long id){
        return repository.findById(id);
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

    @PostMapping("/{id}")
    public void addReview(Review review,@PathVariable("id") Long AuctionId,HttpServletRequest request,HttpServletResponse response) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        Auction result = restTemplate.getForObject("http://localhost:8080/api/auctions/" + AuctionId,Auction.class);
        Review newReview = new Review(review.getContent(),review.getScore());
        result.addReview(newReview);
        auctionRepository.save(result);
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }
    @GetMapping("/edit/{id}")
    public void getEdit(@PathVariable("id") Long id,HttpServletRequest request,HttpServletResponse response,Review review) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/api/reviews/edit/"+id,review);
        String referer = request.getHeader("Referer");
        response.sendRedirect("/auctions");
    }
    @PutMapping("/edit/{id}")
    public void editById(@PathVariable("id") Long id,@RequestBody Review formReview,HttpServletRequest request,HttpServletResponse response ) throws IOException {
        Optional<Review> review = repository.findById(id);
        Review newReview = review.get();
        newReview.setContent(formReview.getContent());
        newReview.setScore(formReview.getScore());
        repository.save(newReview);
        String referer = request.getHeader("Referer");
        response.sendRedirect("/auctions");
    }
}
