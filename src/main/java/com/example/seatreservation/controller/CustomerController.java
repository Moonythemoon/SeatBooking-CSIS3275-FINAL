package com.example.seatreservation.controller;

import com.example.seatreservation.model.Customer;
import com.example.seatreservation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("remainingSeats", 20 - customerService.findAll().size());
        return "index";
    }

    @PostMapping("/reserve")
    public String reserve(@RequestParam String seatno, @RequestParam String name, @RequestParam("tdate") String tdate, Model model) {
        if (seatno.isEmpty() || name.isEmpty() || tdate.isEmpty()) {
            model.addAttribute("error", "All fields are required");
            return "index";
        }

        if (customerService.findBySeatno(seatno) != null) {
            model.addAttribute("error", "Seat is already reserved");
            return "index";
        }

        Customer customer = new Customer();
        customer.setSeatno(seatno);
        customer.setName(name);
        customer.setTdate(LocalDate.parse(tdate));

        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editSubmit(@PathVariable Long id, @ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/";
    }
}
