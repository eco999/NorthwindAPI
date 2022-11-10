package com.sparta.sleepint.northwindapi.repositories;

import com.sparta.sleepint.northwindapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
