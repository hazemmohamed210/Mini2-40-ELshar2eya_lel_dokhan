package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        if(rating == null) throw new IllegalArgumentException();

        Rating newRating = ratingRepository.save(rating);
        return newRating;
    }

    public Rating updateRating(String id, Rating updatedRating) {
        if(id == null || updatedRating == null) throw new IllegalArgumentException();

        Optional<Rating> toBeUpdatedRatingOptional = ratingRepository.findById(id);
        Rating toBeUpdatedRating;

        if(toBeUpdatedRatingOptional.isPresent()) toBeUpdatedRating = toBeUpdatedRatingOptional.get();
        else return null;

        toBeUpdatedRating.setScore(updatedRating.getScore());
        toBeUpdatedRating.setComment(updatedRating.getComment());
        ratingRepository.save(toBeUpdatedRating);

        return toBeUpdatedRating;
    }

    public void deleteRating(String id) {
        if(id == null) throw new IllegalArgumentException();

        if(!ratingRepository.existsById(id)) return;

        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        if(entityId == null || entityId == null) throw new IllegalArgumentException();

        List<Rating> ratings = ratingRepository.findAllByEntityIDAndEntityType(entityId, entityType);
        return ratings;
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        List<Rating> ratings = ratingRepository.findAllByScoreGreaterThan(minScore);
        return ratings;
    }
}
