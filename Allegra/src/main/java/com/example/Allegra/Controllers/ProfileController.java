package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Profile;
import com.example.Allegra.Repositories.ProfileRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @GetMapping("/{id}")
    public Optional<Profile> findById(@PathVariable("id") Long id){
        return profileRepository.findById(id);
    }
}
