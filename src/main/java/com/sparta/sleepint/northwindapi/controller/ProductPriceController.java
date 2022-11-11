package com.sparta.sleepint.northwindapi.controller;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sparta.sleepint.northwindapi.entity.Product;
import com.sparta.sleepint.northwindapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@RestController
public class ProductPriceController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductPriceController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("product/all")
   public List<Product> getAllProducts(){
        return productRepository.findAll();
   }


    @PatchMapping("product/{id}")
    public ResponseEntity<String> updatePrice(@PathVariable Integer id, @RequestParam BigDecimal unitPrice){
        if (productRepository.findById(id).isPresent()) {
            Product product = productRepository.findById(id).get();
            product.setUnitPrice(unitPrice);
            productRepository.save(product);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            try {
                return writeResult(objectMapper.writeValueAsString(product));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
            return writeResult("{\"message\":\"Product not found\"}");
    }

    private ResponseEntity<String> writeResult(String content){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        return new ResponseEntity<>(content, httpHeaders, HttpStatus.OK);
    }


}
