package com.mingqian.springcloud.dao;

import com.mingqian.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: mingqian
 * @DATE: 2020/4/3 14:04
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment findById(@Param("id") Long id);
}
