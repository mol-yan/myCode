
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import javax.annotation.Resource;
import javax.jms.*;

/**
 * @ Author     ：scw
 * @ Date       ：Created in 下午 2:21 2018/7/15 0015
 * @ Description：生产者的实现类
 * @ Modified By：
 * @Version: $version$
 */

public class ProduceServiceImpl implements ProduceService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource(name = "queueDestination")
    private Destination destination;

    /**
     * 发送消息
     * @param msg
     */

    public void sendMessage(final String msg) {
        jmsTemplate.send(destination , new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
        System.out.println("现在发送的消息为： " + msg);
    }
}

