package com.sparta.sleepint.northwindapi.repositories;

import com.sparta.sleepint.northwindapi.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
