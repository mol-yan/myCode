package Config;

import Config.Controller.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testSend {
    @Autowired
    Producer producer;
    @Test
    public void send()
    {

        for(int i=0;i<5;i++)
            producer.sendMapMessage();

    }
}

