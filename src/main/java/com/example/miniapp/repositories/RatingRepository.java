package com.example.miniapp.repositories;

import com.example.miniapp.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    @Query("{ 'entityId': ?0, 'entityType': ?1 }")
    List<Rating> findAllByEntityIDAndEntityType(long entityID, String type);

    @Query("{ 'score': { $gt: ?0 } }")
    List<Rating> findAllByScoreGreaterThan(Integer score);
}
