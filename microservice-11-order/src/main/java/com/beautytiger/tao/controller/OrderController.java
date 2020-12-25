package com.beautytiger.tao.controller;

import com.beautytiger.tao.entities.Cart;
import com.beautytiger.tao.entities.Product;
import com.beautytiger.tao.entities.Order;
import com.beautytiger.tao.service.CartClientService;
import com.beautytiger.tao.service.OrderService;
import com.beautytiger.tao.service.ProductClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClientService productService;

    @Autowired
    private CartClientService cartService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<Order> list() {
        String userIdStr = request.getHeader("userId");
        if (userIdStr == null || userIdStr.equals("")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Long userId = Long.parseLong(userIdStr);
        return orderService.getByUser(userId);
    }

    // 在商品中直接购买
    @RequestMapping(value="/", method= RequestMethod.POST)
    public boolean add(@RequestBody Order order) {
        if (order == null || order.getProductId() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        logger.info(order.getProductId().toString());
        String userIdStr = request.getHeader("userId");
        if (userIdStr == null || userIdStr.equals("")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Long userId = Long.parseLong(userIdStr);

        Product product = productService.get(order.getProductId());
        if (product == null || product.getPid() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return orderService.add(userId, order.getProductId(), product.getProductPrice());
    }

    // 从购物车购买
    @RequestMapping(value="/fromcart", method= RequestMethod.POST)
    public boolean fromCart(@RequestBody Cart cart) {
        String userIdStr = request.getHeader("userId");
        if (userIdStr == null || userIdStr.equals("")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Long userId = Long.parseLong(userIdStr);

        if (cart == null || cart.getId() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Cart realCart = cartService.get(cart.getId());
        if (realCart == null || realCart.getId() == null || realCart.getId() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        boolean handleCartResult = cartService.buy(realCart.getId());
        if (!handleCartResult) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Product product = productService.get(realCart.getProductId());
        if (product == null || product.getPid() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return orderService.add(userId, product.getPid(), product.getProductPrice());
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Order get(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }

}
