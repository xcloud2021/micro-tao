package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "microservice-cart")
public interface CartClientService {

    @RequestMapping(value = "/api/v1/cart/{id}", method = RequestMethod.GET)
    Cart get(@PathVariable("id") Long id);
}
