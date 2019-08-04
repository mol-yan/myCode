package com.hangyan.activemq.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSConsumer;

/*
 * 客户控制器
 */
@RestController
public class ConsumerController {
    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination = "springboot.queue.test")
    public void receiveQueue(String msg) {
        logger.info("接收到消息：{}",msg);
    }
}
