package com.sparta.sleepint.northwindapi.controller;

import com.sparta.sleepint.northwindapi.entity.Customer;
import com.sparta.sleepint.northwindapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Search Customer by Name
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getByName(@RequestParam String name) {

        List<Customer> results = customerRepository.findCustomersByContactNameContainingIgnoreCase(name);

        HttpStatus status = results.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(results, status);

    }

    // Find Customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getByID(@PathVariable String id) {

        Customer result = customerRepository.findCustomersById(id);

        HttpStatus status = result == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(result, status);

    }
}
