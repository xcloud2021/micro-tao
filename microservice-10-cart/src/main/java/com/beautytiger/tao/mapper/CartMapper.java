package com.beautytiger.tao.mapper;

import com.beautytiger.tao.entities.Cart;

import java.util.List;

//@Mapper  // 或者在启动类上加注解 @MapperScan
public interface CartMapper {
    Cart findById(Long id);
    List<Cart> findByUser(Long userId);
    boolean add(Long userId, Long productId);
    boolean delete(Long id);
    boolean buy(Long id);
}