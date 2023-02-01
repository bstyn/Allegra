package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    @Getter Long profile_id;
    @Getter @Setter private String name;
    @Getter @Setter private String lastname;
    @Getter @Setter private String email;
    @Getter @Setter private String username;
    @Getter @Setter private String password;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @Getter @Setter private Address address;

    @ManyToMany
    @JoinTable(
            name = "users_auction",
            joinColumns = { @JoinColumn(name = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "auction_id")})
    @Getter Set<Auction> usersAuction = new HashSet<Auction>();

    protected Profile() {}

    public Profile(String name, String lastname,String email,String username, String password){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\n" +
                "Last Name: " + this.lastname + "\n" +
                "Email: " + this.email + "\n" +
                "Username:" + this.username + this.address;


    }

    public void addAuction(Auction auction){
        this.usersAuction.add(auction);
        auction.auctionsUsers.add(this);
    }
}
