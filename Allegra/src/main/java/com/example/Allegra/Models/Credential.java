package com.example.Allegra.Models;

import lombok.Getter;
import lombok.Setter;

public class Credential {

    @Getter @Setter private String username;
    @Getter @Setter private String password;

    public Credential(String username, String password){
        setUsername(username);
        setPassword(password);
    }
}
