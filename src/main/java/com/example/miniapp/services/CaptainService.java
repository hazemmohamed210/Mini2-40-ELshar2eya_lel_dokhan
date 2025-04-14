package com.example.miniapp.services;

import com.example.miniapp.models.Captain;
import com.example.miniapp.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainService {

    private final CaptainRepository captainRepository;

    @Autowired
    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    public Captain addCaptain(Captain captain) {
        return captainRepository.save(captain);}

    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();}

    public Captain getCaptainById(Long id){
        return captainRepository.findById(id).orElseThrow(() -> new RuntimeException("captain not found with id: " + id)); }

    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }

    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        Captain captain = captainRepository.findByLicenseNumber(licenseNumber);
        if (captain == null) {
            throw new RuntimeException("Captain with license number " + licenseNumber + " not found");
        }
        return captain;
    }
}
