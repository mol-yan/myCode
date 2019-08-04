package com.cmcc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class applicationSpring {


    public static void main(String[] args) {
        System.out.println("applicationSpring");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessagePrinter printer= context.getBean(MessagePrinter.class);
        printer.printMessage();

    }
}
