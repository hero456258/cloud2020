package com.mingqian.springcloud.controller;

import com.mingqian.springcloud.common.Result;
import com.mingqian.springcloud.entity.Payment;
import com.mingqian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;


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

    @GetMapping("/discovery")
    public Object getDiscoveryMessage(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务：" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("实例：" + instance.getHost() + instance.getPort() + instance.getUri() + instance.getServiceId());
        }

        return this.discoveryClient;
    }
}
