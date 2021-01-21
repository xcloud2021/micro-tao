package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${service.microservice-product.name}", url = "${service.microservice-product.name}")
public interface ProductClientService {

    @RequestMapping(value = "/api/v1/product/{id}", method = RequestMethod.GET)
    Product get(@PathVariable("id") Long id);

}
