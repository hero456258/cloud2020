package com.mingqian.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mingqian.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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


    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
