package com.sparta.sleepint.northwindapi.dto;

import java.math.BigDecimal;

public class SuppProdDTO {
    private String categoryName;
    private String prodSupplierName;
    private int productID;
    private String productName;
    private String productQuantityPerUnit;
    private BigDecimal productUnitPrice;
    private short productUnitsInStock;
    private short productUnitsOnOrder;
    private short productReorderLevel;
    private boolean productDiscontinued;

    public SuppProdDTO(String categoryName, String prodSupplierName, int productID, String productName, String productQuantityPerUnit, BigDecimal productUnitPrice, short productUnitsInStock, short productUnitsOnOrder, short productReorderLevel, boolean productDiscontinued) {
        this.categoryName = categoryName;
        this.prodSupplierName = prodSupplierName;
        this.productID = productID;
        this.productName = productName;
        this.productQuantityPerUnit = productQuantityPerUnit;
        this.productUnitPrice = productUnitPrice;
        this.productUnitsInStock = productUnitsInStock;
        this.productUnitsOnOrder = productUnitsOnOrder;
        this.productReorderLevel = productReorderLevel;
        this.productDiscontinued = productDiscontinued;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProdSupplierName() {
        return prodSupplierName;
    }

    public void setProdSupplierName(String prodSupplierName) {
        this.prodSupplierName = prodSupplierName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantityPerUnit() {
        return productQuantityPerUnit;
    }

    public void setProductQuantityPerUnit(String productQuantityPerUnit) {
        this.productQuantityPerUnit = productQuantityPerUnit;
    }

    public BigDecimal getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(BigDecimal productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public short getProductUnitsInStock() {
        return productUnitsInStock;
    }

    public void setProductUnitsInStock(short productUnitsInStock) {
        this.productUnitsInStock = productUnitsInStock;
    }

    public short getProductUnitsOnOrder() {
        return productUnitsOnOrder;
    }

    public void setProductUnitsOnOrder(short productUnitsOnOrder) {
        this.productUnitsOnOrder = productUnitsOnOrder;
    }

    public short getProductReorderLevel() {
        return productReorderLevel;
    }

    public void setProductReorderLevel(short productReorderLevel) {
        this.productReorderLevel = productReorderLevel;
    }

    public boolean isProductDiscontinued() {
        return productDiscontinued;
    }

    public void setProductDiscontinued(boolean productDiscontinued) {
        this.productDiscontinued = productDiscontinued;
    }


    @Override
    public String toString() {
        return "SuppProdDTO[" +
                "prodSupplierName='" + prodSupplierName + '\'' +
                ", productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productQuantityPerUnit='" + productQuantityPerUnit + '\'' +
                ", productUnitPrice=" + productUnitPrice +
                ", productUnitsInStock=" + productUnitsInStock +
                ", productUnitsOnOrder=" + productUnitsOnOrder +
                ", productReorderLevel=" + productReorderLevel +
                ", productDiscontinued=" + productDiscontinued +
                ']';
    }
}
