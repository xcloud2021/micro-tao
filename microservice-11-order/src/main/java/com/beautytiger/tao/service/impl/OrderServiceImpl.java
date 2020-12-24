package com.beautytiger.tao.service.impl;

import com.beautytiger.tao.entities.Order;
import com.beautytiger.tao.mapper.OrderMapper;
import com.beautytiger.tao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order getById(Long id) {
        return orderMapper.findById(id);
    }

    @Override
    public List<Order> getByUser(Long userId) {
        return orderMapper.findByUser(userId);
    }

    @Override
    public boolean add(Long userId, Long productId, Long productPrice) {
        return orderMapper.add(userId, productId, productPrice);
    }
}
