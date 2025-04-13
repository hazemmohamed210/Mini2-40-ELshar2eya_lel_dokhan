package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private LocalDateTime TripDate;
    private String Origin;
    private String Destination;
    private Double TripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Trip(LocalDateTime TripDate, String Origin, String Destination, Double TripCost) {
        this.TripDate = TripDate;
        this.Origin = Origin;
        this.Destination = Destination;
        this.TripCost = TripCost;
    }
}
