package com.beautytiger.tao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.beautytiger.tao"})
@EnableHystrix
//@EnableEurekaClient
@MapperScan("com.beautytiger.tao.mapper")
@SpringBootApplication
public class OrderProvider {
    public static void main(String[] args) {
        SpringApplication.run(OrderProvider.class, args);
    }
}
