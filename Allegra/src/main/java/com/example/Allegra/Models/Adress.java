package com.example.Allegra.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adress {

    @Id
    @GeneratedValue
    private long id;
    private String country;
    private String postcode;
    private String city;
    private String street;
    private int number;
}
