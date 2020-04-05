package com.mingqian.springcloud.service.impl;

import com.mingqian.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfoOk(Integer id) {

        return "线程池 " + Thread.currentThread().getName() + "  paymentInfoOk,id: " + id + "\t" + "哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfoTimeOut(Integer id) {

        int sleepNumber = 3;

        try {
            TimeUnit.SECONDS.sleep(sleepNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池" + Thread.currentThread().getName() + "paymentInfoTimeOut,id" + id + "hahah" ;
//        int age = 10 / 0;
//        return "线程池 " + Thread.currentThread().getName() + "  paymentInfoTimeOut,id:" + id;

    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池 " + Thread.currentThread().getName() + "  paymentInfoTimeOutHandler,id: " + id + "\t" + "smile  ";

    }
}
