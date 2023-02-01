package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    @Getter Long review_id;

    @Getter @Setter String content;
    @Getter @Setter int score;

    @ManyToOne
    @JoinColumn(name = "auction_id",referencedColumnName = "auction_id")
    @Getter @Setter Auction auction;

    private Review(){}

    public Review(String content,int score){
        setContent(content);
        setScore(score);
    }

}
