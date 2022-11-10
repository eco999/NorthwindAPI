package com.sparta.sleepint.northwindapi.controller;

import com.sparta.sleepint.northwindapi.entity.Employee;
import com.sparta.sleepint.northwindapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeTerritoryController {
    private static EmployeeRepository employeeRepository;
//    @GetMapping("Employee/EmployeeByTerritory/{territoryId}")
//    public static List<Employee> getEmployeesByTerritory(@PathVariable int territoryId){
//        //GET list of employees working in a territory using territoryId
//        List<Employee> employeeList = ;
//        return employeeList;
//    }

}
