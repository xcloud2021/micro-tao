package com.beautytiger.tao.controller;

import com.beautytiger.tao.entities.Cart;
import com.beautytiger.tao.entities.Product;
import com.beautytiger.tao.entities.Order;
import com.beautytiger.tao.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RefreshScope
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<Order> list() {
        String userIdStr = request.getHeader("userid");
        if (userIdStr == null || userIdStr.equals("")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Long userId = Long.parseLong(userIdStr);
        return orderService.getByUser(userId);
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public boolean add(@RequestBody Order order) {
        String userIdStr = request.getHeader("userid");
        if (userIdStr == null || userIdStr.equals("")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Long userId = Long.parseLong(userIdStr);
        return orderService.add(userId, order.getProductId(), order.getProductPrice());
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Order get(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }

}
