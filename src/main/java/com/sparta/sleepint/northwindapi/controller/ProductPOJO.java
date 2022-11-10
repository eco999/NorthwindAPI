package com.sparta.sleepint.northwindapi.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.sleepint.northwindapi.entity.Supplier;

public class ProductPOJO {
    public int id;
    @JsonProperty("ProductName")
    public String productName;
    @JsonProperty("QuantityPerUnit")
    public String quantityPerUnit;
    @JsonProperty("UnitPrice")
    public double unitPrice;
    @JsonProperty("UnitsInStock")
    public int unitsInStock;
    @JsonProperty("ReorderLevel")
    public int reorderLevel;
    @JsonProperty("Discontinued")
    public boolean discontinued;
    public Supplier supplier;
}
