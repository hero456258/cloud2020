package com.mingqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 21:13
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystixDashboardMain9001.class, args);
    }
}
