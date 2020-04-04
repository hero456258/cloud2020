package com.mingqian.springcloud.controller;

import com.mingqian.springcloud.common.Result;
import com.mingqian.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: mingqian
 * @DATE: 2020/4/3 15:41
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public Result<Boolean> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,Result.class);
    }

    @GetMapping("/consumer/detail/{id}")
    private Result<Payment> detail(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id,Result.class);
    }
}
