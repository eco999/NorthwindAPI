package com.sparta.sleepint.northwindapi.repositories;

import com.sparta.sleepint.northwindapi.dto.SuppProdDTO;
import com.sparta.sleepint.northwindapi.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    @Query("SELECT new com.sparta.sleepint.northwindapi.dto.SuppProdDTO(s.companyName, p.id, p.productName, p.quantityPerUnit, p.unitPrice, p.unitsInStock, p.unitsOnOrder, p.reorderLevel, p.discontinued) "
    + "FROM Product p LEFT JOIN p.supplierID s")

    List<SuppProdDTO> fetchProdSuppDataLeftJoin();
}
