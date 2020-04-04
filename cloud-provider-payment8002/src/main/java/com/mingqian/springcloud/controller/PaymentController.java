package com.mingqian.springcloud.controller;

import com.mingqian.springcloud.common.Result;
import com.mingqian.springcloud.entity.Payment;
import com.mingqian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mingqian
 * @DATE: 2020/4/3 14:22
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public Result<Payment> detail(@PathVariable("id") Long id) {

        log.info("查询serverPort:" + serverPort);

        Payment payment = paymentService.findById(id);

        if (payment != null) {
            return  Result.ok(payment);
        }

        return Result.fail(1000,"未找到相应的数据");
    }

    @PostMapping("/create")
    public Result<Boolean> create(@RequestBody Payment payment) {

        log.info("添加serverPort:" + serverPort);

        int result = paymentService.create(payment);

        if (result > 0) {
            log.info("插入数据成功" + result);
            return Result.ok(Boolean.TRUE);
        }else {
            log.info("插入数据成功失败" + result);
            return Result.fail(1000, "插入失败");
        }

    }

    @GetMapping("/lb")
    public String getLB(){
        return serverPort;
    }
}
