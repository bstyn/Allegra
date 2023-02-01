package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String lastname;
    @Getter @Setter private String email;
    @Getter @Setter private Date birth_date;
    @Getter @Setter private String username;
    @Getter @Setter private String password;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    @Getter @Setter private Address address;

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
}
