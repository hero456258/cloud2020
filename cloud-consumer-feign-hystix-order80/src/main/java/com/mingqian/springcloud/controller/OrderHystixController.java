package com.mingqian.springcloud.controller;

import com.mingqian.springcloud.service.PaymentHystixService;
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
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentHystixService.paymentInfoTimeOut(id);
        return result;
    }

}
