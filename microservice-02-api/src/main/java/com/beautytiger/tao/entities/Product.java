package com.beautytiger.tao.entities;

import java.io.Serializable;

public class Product implements Serializable {
    private Long pid;
    private String productName;
    private Long productPrice;
    private Long productSales;
    private Long productStatus;

    public Product() {}
    public Product(String productName) {
        this.productName = productName;
    }
    public Product(Long pid, String productName, Long productPrice) {
        this.pid = pid;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Long getProductSales() {
        return productSales;
    }

    public void setProductSales(Long productSales) {
        this.productSales = productSales;
    }

    public Long getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Long productStatus) {
        this.productStatus = productStatus;
    }
}
