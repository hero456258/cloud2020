package com.mingqian.springcloud.service.impl;

import com.mingqian.springcloud.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @Author: mingqian
 * @DATE: 2020/4/11 17:07
 */
@EnableBinding(Source.class) // 定义消息推送的管道
@Slf4j
public class MessageProviderImpl implements MessageProvider {

    @Autowired
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {

        String message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        log.info("************" + message);
        return message;
    }
}
