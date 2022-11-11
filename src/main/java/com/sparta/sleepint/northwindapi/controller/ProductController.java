package com.sparta.sleepint.northwindapi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.sleepint.northwindapi.dto.SuppProdDTO;
import com.sparta.sleepint.northwindapi.entity.Category;
import com.sparta.sleepint.northwindapi.entity.Supplier;
import com.sparta.sleepint.northwindapi.exceptions.ControllerExceptionHandler;
import com.sparta.sleepint.northwindapi.exceptions.ResourceException;
import com.sparta.sleepint.northwindapi.repositories.CategoryRepository;
import com.sparta.sleepint.northwindapi.repositories.ProductRepository;
import com.sparta.sleepint.northwindapi.repositories.SupplierRepository;
import com.sparta.sleepint.northwindapi.util.JoinQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private JoinQueryService joinQueryService;
    private ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, SupplierRepository supplierRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping(value = "/product/supplier/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSuppProductsLeftJoin() {
        //(joinQueryService.getSuppProductsLeftJoin(), HttpStatus.OK);
        List<SuppProdDTO> results = joinQueryService.getSuppProductsLeftJoin();
        ResponseEntity<String> response;
        try {
            if (results.size() == 0) {
                throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find any matches containing this name.");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            response = new ResponseEntity<>(objectMapper.writeValueAsString(results), HttpStatus.OK);
        } catch (ResourceException e) {
            response = ControllerExceptionHandler.handleException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return response;

    }

}
