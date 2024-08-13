package com.example.seatreservation;

import com.example.seatreservation.model.Customer;
import com.example.seatreservation.repository.CustomerRepository;
import com.example.seatreservation.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindBySeatno() {
        Customer customer = new Customer();
        customer.setSeatno("2A");

        when(customerRepository.findBySeatno("2A")).thenReturn(customer);

        Customer found = customerService.findBySeatno("2A");

        assertEquals("2A", found.getSeatno());
    }

    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setSeatno("2A");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer saved = customerService.save(customer);

        assertEquals("2A", saved.getSeatno());
        verify(customerRepository, times(1)).save(customer);
    }
}
