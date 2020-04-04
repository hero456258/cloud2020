package com.mingqian.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: mingqian
 * @DATE: 2020/4/3 13:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 流水号
     */
    private String serial;
}
