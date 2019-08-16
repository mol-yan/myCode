package Config.Controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.Serializable;

@Component
public class Producer {
    //config文件中类型是JmsTemplate，但是JmsMessagingTemplate一样能自动装配到

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private ActiveMQQueue activeMQQueue;
    @Resource
    private JmsTemplate jmsTemplate;
    //可以自定义一个map，session.createMapMessage(map)
    public void sendMapMessage() {

        jmsTemplate.send(activeMQQueue,new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {

                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("name:","mol");
                mapMessage.setInt("age:",18);
                mapMessage.setDouble("score",98.73);
                mapMessage.setJMSType("MapMessage");
                return mapMessage;
            }
        });
        System.out.println("send success");

    }


    public void sendTextMessage(final String msg) {
        System.out.println("jmsTemplate model:");
        System.out.println(jmsTemplate.getDeliveryMode());
        jmsTemplate.send(activeMQQueue,new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {

                TextMessage textMessage= session.createTextMessage(msg);
                textMessage.setJMSType("TextMessage");
                return textMessage;
            }
        });
        System.out.println("send success");

    }


    //如果和bp通信，如何create 不同类型的message？
    //    @Scheduled(fixedDelay = 3000)
    public void send_map_jmsMessagingTemplate()
    {

        jmsMessagingTemplate.convertAndSend(activeMQQueue,"aaa");
        System.out.println("send success");
    }

}
