package Com.hangyan.Controller;


import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ActiveMQQueue queue;

    /**
     * 发送消息，estination是发送到的队列，message是待发送的消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message) {
        System.out.println(jmsTemplate.getDeliveryMode());
        jmsTemplate.convertAndSend(destination, message);
    }
    /**
     * 发送消息，message是待发送的消息
     * @param message
     */
    public void sendMessage(final String message) {
        System.out.println(jmsTemplate.getDeliveryMode());
        jmsTemplate.convertAndSend(queue,message);
    }

}
