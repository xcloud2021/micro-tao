package com.beautytiger.tao.service.impl;

import com.beautytiger.tao.entities.Product;
import com.beautytiger.tao.service.ProductClientService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductClientServiceFallBack implements ProductClientService {

    // 模拟服务提供者无法提供服务：服务关闭，网络失联等
    @Override
    public Product get(Long id) {
        Long invalidPrice = (long) -998;
        Long invalidID = (long) -998;
        return new Product(invalidID, "ID=" + id + "商品无法提供服务", invalidPrice);
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }
}
