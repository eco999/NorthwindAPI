package com.sparta.sleepint.northwindapi.repositories;

import com.sparta.sleepint.northwindapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
