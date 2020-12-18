package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.Product;

import java.util.List;


public interface ProductService {
    boolean add(Product product);

    Product get(Long id);

    List<Product> list();
}
