package com.mingqian.springcloud.service;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 8:56
 */
public interface PaymentService {
    String paymentInfoOk(Integer id);

    String paymentInfoTimeOut(Integer id);

    /**
     * 服务熔断
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
