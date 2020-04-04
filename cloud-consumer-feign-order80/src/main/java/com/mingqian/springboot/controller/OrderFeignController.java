package com.mingqian.springboot.controller;

import com.mingqian.springboot.entity.Payment;
import com.mingqian.springboot.service.PaymentService;
import com.mingqian.springcloud.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mingqian
 * @DATE: 2020/4/4 21:45
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public Result<Payment> detail(@PathVariable("id") Long id) {
        return paymentService.detail(id);
    }

    @GetMapping("/timeOut")
    public String timeOut() {
        //openFeign-ribbon,客户端一般默认等待一秒钟
        return paymentService.timeOut();
    }

}
