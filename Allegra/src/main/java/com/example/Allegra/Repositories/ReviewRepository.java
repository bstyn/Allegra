package com.example.Allegra.Repositories;

import com.example.Allegra.Models.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review,Long> {

    Optional<Review> findById(Long aLong);
}
