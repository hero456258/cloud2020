package com.mingqian.springcloud.lib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: mingqian
 * @DATE: 2020/4/4 19:38
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        for (;;) {
            current = atomicInteger.get();
            if (current >= Integer.MAX_VALUE) {
                next = 0;
            }else {
                next = current + 1;
            }

            if (this.atomicInteger.compareAndSet(current,next)){
                log.info("第几次调用:" + next);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
