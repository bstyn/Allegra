package com.example.Allegra.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Locale;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private Date birth_date;

    protected Profile() {}

    public Profile(String name, String lastname,String email,Date birth_date){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birth_date = birth_date;
    }

}
