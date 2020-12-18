package com.beautytiger.tao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.beautytiger.tao.mapper")
@SpringBootApplication
public class ProductProvider {
    public static void main(String[] args) {
        SpringApplication.run(ProductProvider.class, args);
    }
}
