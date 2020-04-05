package com.mingqian.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 19:44
 */
@Component
public class PaymentFallbackService  implements  PaymentHystixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "--------PaymentFallbackService fall back paymentInfoOk,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "--------PaymentFallbackService fall back paymentInfoTimeOut,o(╥﹏╥)o";
    }
}
