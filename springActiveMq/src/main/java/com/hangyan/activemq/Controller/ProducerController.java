package com.hangyan.activemq.Controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/*
 * 队列消息控制器
 */
@Component

public class ProducerController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQQueue queue;

    public void sendMessage() {
        jmsMessagingTemplate.convertAndSend(queue,"aadasdcs");
    }
}
