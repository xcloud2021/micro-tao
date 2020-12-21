package com.beautytiger.tao.controller;

import com.beautytiger.tao.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductConsumerController {
    private static final String URL_PREFIX="http://microservice-product";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/add")
    public boolean add(Product product) {
        if (product.getProductPrice() == null || product.getProductPrice() <= 0 ) {
            return false;
        }
        if (product.getProductName() == null || product.getProductName().equals("")) {
            return false;
        }
        return restTemplate.postForObject(URL_PREFIX + "/api/v1/product/", product, Boolean.class);
    }

    @RequestMapping(value="/{id}")
    public Product get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL_PREFIX + "/api/v1/product/" + id, Product.class);
    }

    @RequestMapping(value="/")
    public List<Product> list() {
        return restTemplate.getForObject(URL_PREFIX + "/api/v1/product/", List.class);
    }
}
