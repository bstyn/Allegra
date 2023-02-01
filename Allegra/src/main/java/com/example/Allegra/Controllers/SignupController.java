package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Address;
import com.example.Allegra.Models.Credential;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Models.UserDTO;
import com.example.Allegra.Repositories.ProfileRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/signup")
public class SignupController {

    private final ProfileRepository profileRepository;

    public SignupController(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @PostMapping
    public void signup(UserDTO user, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
        String hashed = bytesToHex(hash);
        Address address = new Address(user.getCountry(),user.getPostcode(),user.getCity(),user.getStreet(),user.getNumber());
        Profile profile = new Profile(user.getName(),user.getLastname(),user.getEmail(),user.getUsername(),hashed);
        profile.setAddress(address);
        profileRepository.save(profile);
        response.sendRedirect("/login");

    }



}
