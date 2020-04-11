package com.mingqian.springcloud.controller;

import com.mingqian.springcloud.common.Result;
import com.mingqian.springcloud.entity.Payment;
import com.mingqian.springcloud.lib.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin", String.class);
    }

    @PostMapping("/consumer/payment/create")
    public Result<Boolean> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, Result.class);
    }

    @GetMapping("/consumer/detail/{id}")
    private Result<Payment> detail(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, Result.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (!instances.isEmpty() && instances != null) {
            ServiceInstance serverInstance = loadBalancer.instances(instances);
            URI uri = serverInstance.getUri();
            return restTemplate.getForObject(uri + "/payment/lb", String.class);
        } else {
            return null;
        }
    }
}
