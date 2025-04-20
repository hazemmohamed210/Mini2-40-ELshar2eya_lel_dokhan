package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip){
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip updateTrip(Long id, Trip trip) {
        Optional<Trip> tripOptional = tripRepository.findById(id);
        Trip toBeUpdatedTrip;
        if (tripOptional.isPresent()) {
            toBeUpdatedTrip = tripOptional.get();
        } else {
            return null;
        }
        toBeUpdatedTrip.setOrigin(trip.getOrigin());
        toBeUpdatedTrip.setDestination(trip.getDestination());
        toBeUpdatedTrip.setTripCost(trip.getTripCost());
        tripRepository.save(toBeUpdatedTrip);
        return toBeUpdatedTrip;
    }

    public void deleteTrip(long id) {
        if(tripRepository.existsById(id)) {
            tripRepository.deleteById(id);
        }
    }

    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate){
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    public List<Trip> findTripsByCaptainId(Long captainId){
        return tripRepository.findByCaptainId(captainId);
    }
}
