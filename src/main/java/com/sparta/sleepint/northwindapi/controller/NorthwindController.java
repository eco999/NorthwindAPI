package com.sparta.sleepint.northwindapi.controller;

import com.sparta.sleepint.northwindapi.repositories.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NorthwindController {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final TerritoryRepository territoryRepository;

    public NorthwindController(CategoryRepository categoryRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, OrderRepository orderRepository, ProductRepository productRepository, SupplierRepository supplierRepository, TerritoryRepository territoryRepository){
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.territoryRepository = territoryRepository;
    }
}
