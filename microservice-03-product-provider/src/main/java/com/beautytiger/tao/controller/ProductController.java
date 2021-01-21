package com.beautytiger.tao.controller;

import com.beautytiger.tao.entities.Product;
import com.beautytiger.tao.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${bussiness.discount}")
    private Long discount;

    @RequestMapping(value="/", method= RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @HystrixCommand(fallbackMethod = "getFallBack")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {

        Product product =  productService.get(id);
        // 服务异常，出发fallback
        if (product == null) {
            throw new RuntimeException("ID=" + id + "无效");
        }
        Long realPrice = product.getProductPrice() * discount / 100;
        product.setDiscountPrice(realPrice);
        return product;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Product> list() {
        List<Product> products = productService.list();
        for (Product product : products ) {
            Long realPrice = product.getProductPrice() * discount / 100;
            product.setDiscountPrice(realPrice);
        }
        return products;
    }

    public Product getFallBack(@PathVariable("id") Long id) {
        Long invalidPrice = (long) -999;
        Long invalidID = (long) -999;
        return new Product(invalidID, "ID=" + id + "商品不存在", invalidPrice);
    }
}
