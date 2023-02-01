package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Auction {

    @Id
    @GeneratedValue
    @Column(name = "auction_id")
    @Getter
    private Long auction_id;

    @Getter @Setter private String name;
    @Getter @Setter private Date start_date;
    @Getter @Setter private Date end_date;
    @Getter @Setter private String url;
    @Getter @Setter private double price;

    @ManyToMany(mappedBy = "usersAuction")
    Set<Profile> auctionsUsers = new HashSet<Profile>();

    @OneToMany(mappedBy = "auction",cascade = CascadeType.ALL)
    Set<Review> reviews = new HashSet<Review>();

    private Auction(){}

    public Auction(String name, Date start_date,Date end_date,String url, double price){
        setName(name);
        setStart_date(start_date);
        setEnd_date(end_date);
        setUrl(url);
        setPrice(price);
    }

    public void addReview(Review review){
        reviews.add(review);
        review.setAuction(this);
    }

    public void addUsers(Profile profile){
        this.auctionsUsers.add(profile);
        profile.usersAuction.add(this);
    }
}
