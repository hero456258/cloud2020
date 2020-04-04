package com.mingqian.springcloud.service;

import com.mingqian.springcloud.entity.Payment;

/**
 * @Author: mingqian
 * @DATE: 2020/4/3 14:19
 */
public interface PaymentService {

    /**
     * 创建
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Payment findById(Long id);
}
