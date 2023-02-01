package com.example.Allegra;

import com.example.Allegra.Models.Address;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Repositories.AddressRepository;
import com.example.Allegra.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class AllegraApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AllegraApplication.class, args);
		ProfileRepository repo = context.getBean(ProfileRepository.class);
		Address address = new Address("Poland","84-200","Gdańsk","Świętojańska",22);
		Profile profile = new Profile("Bartek","Nazwisko", "example@example.com", "bstyn", "admin");
		profile.setAddress(address);
		repo.save(profile);

		System.out.println(profile);

	}


}
