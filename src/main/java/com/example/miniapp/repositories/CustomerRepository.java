package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.email LIKE %?1")
    List<Customer> findByEmailDomain(String domain);

    @Query("SELECT c FROM Customer c WHERE c.phoneNumber LIKE ?1%")
    List<Customer> findByPhonePrefix(String prefix);
}
