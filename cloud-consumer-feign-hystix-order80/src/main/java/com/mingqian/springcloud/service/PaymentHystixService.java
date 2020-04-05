package com.mingqian.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 9:53
 */
@FeignClient("cloud-provider-hystrix-payment")
public interface PaymentHystixService {

    @GetMapping("/payment/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
