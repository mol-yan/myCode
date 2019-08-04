package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Power {
    public Power() {
        super();
    }

    public void supply(){
        System.out.println("提供电源中.....");

    }
}
