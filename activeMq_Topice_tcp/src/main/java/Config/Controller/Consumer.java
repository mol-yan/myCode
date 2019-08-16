package Config.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class Consumer {
//    @JmsListener(destination = "${myqueue}")
    public void receive(Message Message) throws JMSException {
        System.out.println("*********消费者收到消息: "+Message.getJMSType());
    }

}
