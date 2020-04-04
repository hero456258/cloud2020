package com.mingqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: mingqian
 * @DATE: 2020/4/4 15:55
 */
@RestController
@Slf4j
public class OrderConsulController {

    @Autowired
    private RestTemplate restTemplate;


    public static final String INVOKE_URL = "http://consul-provider-payment";


    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}
