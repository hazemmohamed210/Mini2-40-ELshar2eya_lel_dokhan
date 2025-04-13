package com.example.miniapp.services;

import com.example.miniapp.repositories.RatingRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
}
