package com.sparta.sleepint.northwindapi.repositories;

import com.sparta.sleepint.northwindapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
