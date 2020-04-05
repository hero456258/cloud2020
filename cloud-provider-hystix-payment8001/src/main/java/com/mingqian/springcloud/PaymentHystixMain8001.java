package com.mingqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 8:54
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
public class PaymentHystixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystixMain8001.class, args);
    }
}
