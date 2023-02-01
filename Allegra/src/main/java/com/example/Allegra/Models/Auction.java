package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Auction {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Getter
    private Long id;

    @Getter @Setter private String name;
    @Getter @Setter private Date start_date;
    @Getter @Setter private Date end_date;
    @Getter @Setter private double price;

    private Auction(){}

    public Auction(String name, Date start_date,Date end_date, double price){
        setName(name);
        setStart_date(start_date);
        setEnd_date(end_date);
        setPrice(price);
    }
}
