package Config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class ConfigBean {
    @Value("${mytopic}")
    private String myTopic_name;

    @Bean
    public ActiveMQTopic topic()
    {
        return new ActiveMQTopic(myTopic_name);
    }
}
