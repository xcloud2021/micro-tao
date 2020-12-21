package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "microservice-product")
public interface ProductClientService {

    @RequestMapping(value = "/api/v1/product/{id}", method = RequestMethod.GET)
    Product get(@PathVariable("id") Long id);

    @RequestMapping(value = "/api/v1/product/", method = RequestMethod.GET)
    List<Product> list();

    @RequestMapping(value = "/api/v1/product/", method = RequestMethod.POST)
    boolean add(@RequestBody Product product);
}
