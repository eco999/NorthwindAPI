package com.sparta.sleepint.northwindapi.controller;


import com.sparta.sleepint.northwindapi.dto.SuppProdDTO;
import com.sparta.sleepint.northwindapi.entity.Category;
import com.sparta.sleepint.northwindapi.entity.Product;
import com.sparta.sleepint.northwindapi.entity.Supplier;
import com.sparta.sleepint.northwindapi.repositories.CategoryRepository;
import com.sparta.sleepint.northwindapi.repositories.ProductRepository;
import com.sparta.sleepint.northwindapi.repositories.SupplierRepository;
import com.sparta.sleepint.northwindapi.util.JoinQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @GetMapping("/product/supplier/all")
    public ResponseEntity<List<SuppProdDTO>> getSuppProductsLeftJoin() {
        return new ResponseEntity<List<SuppProdDTO>>(joinQueryService.getSuppProductsLeftJoin(), HttpStatus.OK);
    }

    @GetMapping("/supplier/{id}")
    public Supplier getSupplierByID(@PathVariable int id){
        Supplier supplier = supplierRepository.findById(id).orElse(null);

        return supplier;
    }

    @GetMapping("/category/{id}")
    public Category getCategoryByID(@PathVariable int id){
        Category category = categoryRepository.findById(id).orElse(null);

        return category;
    }


}
