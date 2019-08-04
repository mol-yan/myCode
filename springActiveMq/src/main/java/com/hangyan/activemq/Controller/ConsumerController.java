package com.hangyan.activemq.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSConsumer;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/*
 * 客户控制器
 */
@RestController
public class ConsumerController {
   @JmsListener(destination = "${myqueue}")//从哪个队列取的，这个很重要，生产者的队列是知道的
    public void receive(TextMessage textMessage) throws JMSException {
       System.out.println("******消费者收到消息:"+textMessage.getText());
   }
}
