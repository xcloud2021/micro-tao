package com.beautytiger.tao.mapper;

import com.beautytiger.tao.entities.Order;

import java.util.List;

//@Mapper  // 或者在启动类上加注解 @MapperScan
public interface OrderMapper {

    Order findById(Long id);
    List<Order> findByUser(Long userId);
    boolean add(Long userId, Long productId, Long productPrice);
}