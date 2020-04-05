package com.mingqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 9:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderHystixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystixMain80.class, args);
    }
}
