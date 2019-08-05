package Config.Controller;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired//a类里面注入了b类，原来都是有b这个类，然后通过构造函数绑定，现在ActiveMQTopic没有这个自己
    //写的类，所以用了@Bean方法绑定。
    private ActiveMQTopic activeMQTopic;

    @Scheduled(fixedDelay = 3000)
    public void send_Topic()
    {
        jmsMessagingTemplate.convertAndSend(activeMQTopic,"aaaatopic");
    }

}
