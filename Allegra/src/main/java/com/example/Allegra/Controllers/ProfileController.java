package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Address;
import com.example.Allegra.Models.Auction;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Models.UserDTO;
import com.example.Allegra.Repositories.ProfileRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @GetMapping("/get/{id}")
    public Optional<Profile> findById(@PathVariable("id") Long id){
        return profileRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void getDeletion(@PathVariable("id") Long id,HttpServletResponse response) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/api/profiles/delete/"+id);
        response.sendRedirect("/login");
    }
    @GetMapping("/edit/{id}")
    public void getEdit(@PathVariable("id") Long id,HttpServletResponse response,UserDTO user) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/api/profiles/edit/"+id,user);
        response.sendRedirect("/profile");
    }
    @PutMapping("/edit/{id}")
    public void editById(@PathVariable("id") Long id,@RequestBody UserDTO user){
        Optional<Profile> profile  = profileRepository.findById(id);
        Profile newProfile = profile.get();
        Address newAddress = profile.get().getAddress();
        newProfile.setName(user.getName());
        newProfile.setLastname(user.getLastname());
        newProfile.setEmail(user.getEmail());
        newAddress.setCity(user.getCity());
        newAddress.setCountry(user.getCountry());
        newAddress.setPostcode(user.getPostcode());
        newAddress.setNumber(user.getNumber());
        newAddress.setStreet(user.getStreet());
        newProfile.setAddress(newAddress);
        profileRepository.save(newProfile);



    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        profileRepository.deleteById(id);
        PageController.setProfileId(null);
        response.sendRedirect("/login");
    }


}
