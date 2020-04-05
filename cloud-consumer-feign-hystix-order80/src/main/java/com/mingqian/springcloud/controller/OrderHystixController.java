package com.mingqian.springcloud.controller;

import com.mingqian.springcloud.service.PaymentHystixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 9:55
 */
@RestController
@Slf4j
public class OrderHystixController {

    @Autowired
    private PaymentHystixService paymentHystixService;


    @GetMapping("/consumer/payment/hystix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentHystixService.paymentInfoOk(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        String result = paymentHystixService.paymentInfoTimeOut(id);
        return result;
    }

    public String paymentInfoTimeOutHandler(@PathVariable("id") Integer id) {
        return "我是80消费者自我做服务降级 ";

    }

}
