package com.sparta.sleepint.northwindapi.controller;

import com.sparta.sleepint.northwindapi.entity.Employee;
import com.sparta.sleepint.northwindapi.entity.Territory;
import com.sparta.sleepint.northwindapi.repositories.EmployeeRepository;
import com.sparta.sleepint.northwindapi.repositories.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TerritoryController {
    private final TerritoryRepository territoryRepository;

    @Autowired
    public TerritoryController(TerritoryRepository territoryRepository) {
        this.territoryRepository = territoryRepository;
    }
    @GetMapping("/territory/employees/{territoryId}")
    public Set<Employee> getEmployeesByTerritoryId(@PathVariable String territoryId){
        Set<Employee> employeeSet = territoryRepository.findById(territoryId).get().getEmployees();

        return employeeSet;
    }

    @GetMapping("/territory/{territoryId}")
    public EntityModel<Territory> getTerritoryById(@PathVariable String territoryId) {
        Territory territory = territoryRepository.findById(territoryId).get();
        EntityModel <Territory> entityModel = EntityModel.of(territory);
        //Connect employees to territory
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getEmployeesByTerritoryId(territoryId));
        entityModel.add(webMvcLinkBuilder.withRel("employees"));
        return entityModel;
    }
}
