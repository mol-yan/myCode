package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class AppTest {

    @Autowired
    CDPlayer player;

    @Test
    public void testPlay(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        CDPlayer player=context.getBean(CDPlayer.class);
//        player.play();
    }
}
