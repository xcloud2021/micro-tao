package com.beautytiger.tao.controller;

import com.beautytiger.tao.entities.Product;
import com.beautytiger.tao.entities.Cart;
import com.beautytiger.tao.service.CartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RefreshScope
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/", method= RequestMethod.POST)
    public boolean login(@RequestBody Cart cart) {
        String userIdStr = request.getHeader("userid");
        if (userIdStr == null || userIdStr.equals("")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Long userId = Long.parseLong(userIdStr);
        return cartService.add(userId, cart.getProductId());
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Long id) {
        return cartService.delete(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.POST)
    public boolean buy(@PathVariable("id") Long id) {
        return cartService.buy(id);
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Cart> list() {
        String userIdStr = request.getHeader("userid");
        if (userIdStr == null || userIdStr.equals("")) {
            // https://www.baeldung.com/exception-handling-for-rest-with-spring#controlleradvice
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Long userId = Long.parseLong(userIdStr);
        return cartService.getByUser(userId);
    }

    @HystrixCommand(fallbackMethod = "getFallBack")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Cart get(@PathVariable("id") Long id) {

        Cart cart = cartService.getById(id);
        // 服务异常，出发fallback
        if (cart == null) {
            throw new RuntimeException("ID=" + id + "不存在");
        }
        return cart;
    }

    public Cart getFallBack(@PathVariable("id") Long id) {
        return new Cart();
    }
}
