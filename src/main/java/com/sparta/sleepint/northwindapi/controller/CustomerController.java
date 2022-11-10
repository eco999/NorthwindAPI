package com.sparta.sleepint.northwindapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.sleepint.northwindapi.entity.Customer;
import com.sparta.sleepint.northwindapi.exceptions.ControllerExceptionHandler;
import com.sparta.sleepint.northwindapi.exceptions.ResourceException;
import com.sparta.sleepint.northwindapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    // Search CustomerS by Name
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getByName(@RequestParam String name) {

        List<Customer> results = customerRepository.findCustomersByContactNameContainingIgnoreCase(name);

        ResponseEntity<String> response;

        try {
            if (results.size() == 0) {
                throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find any matches containing this name.");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            response = new ResponseEntity<>(objectMapper.writeValueAsString(results.toArray()), HttpStatus.OK);

            // TODO Change this implementation to return the results mapped into a String

        } catch(ResourceException e) {
            response = ControllerExceptionHandler.handleException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    // Find Customer by ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getByID(@PathVariable String id) {

        Customer result = customerRepository.findCustomerById(id);

        ResponseEntity<String> response;

        try {
            if (result == null) {
                throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find any records with this ID.");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            response = new ResponseEntity<>(objectMapper.writeValueAsString(result), HttpStatus.OK);
            // TODO Change this implementation to return the results mapped into a String

        } catch(ResourceException e) {
            response = ControllerExceptionHandler.handleException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return response;

    }
}
