package com.example.Allegra.Repositories;

import com.example.Allegra.Models.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    List<Profile> findById(long id);
}
