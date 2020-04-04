package com.mingqian.springboot.service;

import com.mingqian.springboot.entity.Payment;
import com.mingqian.springcloud.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: mingqian
 * @DATE: 2020/4/4 21:38
 */
@FeignClient("cloud-payment-service")
public interface PaymentService {

    @GetMapping("/payment/{id}")
    Result<Payment> detail(@PathVariable("id") Long id);
}
