package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.Cart;

import java.util.List;


public interface CartService {
    Cart getById(Long id);
    List<Cart> getByUser(Long userId);
    boolean add(Long userId, Long productId);
    boolean delete(Long id);
    boolean buy(Long id);
}
