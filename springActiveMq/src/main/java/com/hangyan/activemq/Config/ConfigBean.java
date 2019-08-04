package com.hangyan.activemq.Config;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public ActiveMQQueue queue()
    {
        return  new ActiveMQQueue(myQueue);
    }
}
