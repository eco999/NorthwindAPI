package com.sparta.sleepint.northwindapi.repositories;

import com.sparta.sleepint.northwindapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
