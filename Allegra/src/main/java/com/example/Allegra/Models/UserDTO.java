package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {

    @Getter @Setter private String name;
    @Getter @Setter private String lastname;
    @Getter @Setter private String email;
    @Getter @Setter private String username;
    @Getter @Setter private String password;

    @Getter @Setter private String country;
    @Getter @Setter private String postcode;
    @Getter @Setter private String city;
    @Getter @Setter private String street;
    @Getter @Setter private int number;
}
