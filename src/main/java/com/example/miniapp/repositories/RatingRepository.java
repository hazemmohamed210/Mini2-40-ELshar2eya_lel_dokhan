package com.example.miniapp.repositories;

import com.example.miniapp.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {
}
