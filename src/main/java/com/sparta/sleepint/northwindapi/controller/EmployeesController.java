package com.sparta.sleepint.northwindapi.controller;

import com.sparta.sleepint.northwindapi.entity.Employee;
import com.sparta.sleepint.northwindapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {
    private static EmployeeRepository employeeRepository;

    @Autowired
    public EmployeesController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee/{id}")
    public static Employee getEmployee(@PathVariable int id){
         Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @GetMapping("/employee/all")
    public static List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }
}
