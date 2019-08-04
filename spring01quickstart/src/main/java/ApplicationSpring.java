import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        System.out.println("applicationSpring");
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

//        System.out.println("application");
//        MessagePrinter printer = new MessagePrinter();
//        MessageService service = new MessageService();
//        printer.setService(service);
//        printer.printMessage();
}
}
