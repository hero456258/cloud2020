package com.mingqian.springcloud.service.impl;

import com.mingqian.springcloud.dao.PaymentDao;
import com.mingqian.springcloud.entity.Payment;
import com.mingqian.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: mingqian
 * @DATE: 2020/4/3 14:19
 */

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    /**
     * 创建
     *
     * @param payment
     * @return
     */
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }
}
