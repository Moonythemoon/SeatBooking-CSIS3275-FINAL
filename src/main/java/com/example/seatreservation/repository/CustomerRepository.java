package com.example.seatreservation.repository;

import com.example.seatreservation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findBySeatno(String seatno);
}
