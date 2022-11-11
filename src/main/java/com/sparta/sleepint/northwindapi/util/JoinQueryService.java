package com.sparta.sleepint.northwindapi.util;

import com.sparta.sleepint.northwindapi.dto.SuppProdDTO;
import com.sparta.sleepint.northwindapi.entity.Supplier;
import com.sparta.sleepint.northwindapi.repositories.ProductRepository;
import com.sparta.sleepint.northwindapi.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JoinQueryService {

    @Resource
    private SupplierRepository supplierRepository;

    @Resource
    private ProductRepository productRepository;

    public List<SuppProdDTO> getSuppProductsLeftJoin(){
        List<SuppProdDTO> list = supplierRepository.fetchProdSuppDataLeftJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }
}
