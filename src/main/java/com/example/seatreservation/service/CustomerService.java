package com.example.seatreservation.service;

import com.example.seatreservation.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer findBySeatno(String seatno);
    Customer save(Customer customer);
    void deleteById(Long id);
}
