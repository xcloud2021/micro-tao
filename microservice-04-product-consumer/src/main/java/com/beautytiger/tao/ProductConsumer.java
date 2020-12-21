package com.beautytiger.tao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductConsumer {
    public static void main(String[] args) {
        SpringApplication.run(ProductConsumer.class, args);
    }
}
