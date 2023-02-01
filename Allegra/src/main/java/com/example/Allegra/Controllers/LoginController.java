package com.example.Allegra.Controllers;

import com.example.Allegra.Models.Credential;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Repositories.ProfileRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final ProfileRepository profileRepository;

    public LoginController(ProfileRepository profileRepository){
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
    public void findByCredentials(Credential credential ,HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(credential.getPassword().getBytes(StandardCharsets.UTF_8));
        String hashed = bytesToHex(hash);
        Optional<Profile> profile = profileRepository.findByUsernameAndPassword(credential.getUsername(), hashed);
        if (profile.isPresent()){
            PageController.setProfileId(profile.get().getProfile_id());
            response.sendRedirect("/profile");
        }
        else{
            response.sendRedirect("/login");
        }
    }
    @PostMapping("/logout")
    public void logout(HttpServletResponse response) throws IOException {
        PageController.setProfileId(null);
        response.sendRedirect("/login");
    }
}
