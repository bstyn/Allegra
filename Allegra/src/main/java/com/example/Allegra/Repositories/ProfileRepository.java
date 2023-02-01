package com.example.Allegra.Repositories;

import com.example.Allegra.Models.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Optional<Profile> findById(Long id);

    Optional<Profile> findByUsernameAndPassword(String username,String password);

    void deleteById(Long id);
}
