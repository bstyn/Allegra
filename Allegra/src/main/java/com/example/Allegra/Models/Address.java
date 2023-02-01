package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Getter private Long id;

    @Getter @Setter private String country;
    @Getter @Setter private String postcode;
    @Getter @Setter private String city;
    @Getter @Setter private String street;
    @Getter @Setter private int number;

    @OneToOne(mappedBy = "address")
    private Profile profile;

    protected Address(){}

    public Address(String country, String postcode, String city, String street, int number){
        setCountry(country);
        setPostcode(postcode);
        setCity(city);
        setStreet(street);
        setNumber(number);
    }

    @Override
    public String toString() {
        return "Country: " + this.country + "\n" +
                "Postal Code: " + this.postcode + "\n" +
                "city: " + this.city + "\n" +
                "Street: " + this.street + "\n" +
                "Number: " + this.number;

    }
}
