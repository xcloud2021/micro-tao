package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.Order;

import java.util.List;

public interface OrderService {
    Order getById(Long id);
    List<Order> getByUser(Long userId);
    boolean add(Long userId, Long productId, Long productPrice);
}
