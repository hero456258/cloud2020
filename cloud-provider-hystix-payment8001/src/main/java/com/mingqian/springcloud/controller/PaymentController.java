package com.mingqian.springcloud.controller;

import com.mingqian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 9:04
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("------------------" + result);
        return result;

    }

    @GetMapping("/payment/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("/////////////////////" + result);
        return result;
    }

}
