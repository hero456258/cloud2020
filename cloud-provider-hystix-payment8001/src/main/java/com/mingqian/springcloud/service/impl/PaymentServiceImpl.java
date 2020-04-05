package com.mingqian.springcloud.service.impl;

import com.mingqian.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: mingqian
 * @DATE: 2020/4/5 8:56
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问的方法
     * @param id
     * @return
     */
    @Override
    public String paymentInfoOk(Integer id) {

        return "线程池 " + Thread.currentThread().getName() + "  paymentInfoOk,id: " + id + "\t" + "哈哈" ;
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {

        int sleepNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(sleepNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池 " + Thread.currentThread().getName() + "  paymentInfoTimeOut,id: " + id + "\t" + "哈哈" + "耗时"+ sleepNumber +"秒钟" ;

    }
}
