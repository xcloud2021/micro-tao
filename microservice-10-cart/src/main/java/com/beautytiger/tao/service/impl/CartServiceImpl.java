package com.beautytiger.tao.service.impl;

import com.beautytiger.tao.entities.Cart;
import com.beautytiger.tao.mapper.CartMapper;
import com.beautytiger.tao.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public Cart getById(Long id) {
        return cartMapper.findById(id);
    }

    @Override
    public List<Cart> getByUser(Long userId) {
        return cartMapper.findByUser(userId);
    }

    @Override
    public boolean add(Long userId, Long productId) {
        return cartMapper.add(userId, productId);
    }

    @Override
    public boolean delete(Long id) {
        return cartMapper.delete(id);
    }

    @Override
    public boolean buy(Long id) {
        return cartMapper.buy(id);
    }
}
