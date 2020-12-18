package com.beautytiger.tao.mapper;

import com.beautytiger.tao.entities.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper  // 或者在启动类上加注解 @MapperScan
public interface ProductMapper {

    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}