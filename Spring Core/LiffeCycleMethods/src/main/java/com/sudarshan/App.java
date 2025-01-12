package com.sudarshan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        MethodsDemo demo = (MethodsDemo)context.getBean("methods");

        System.out.println(demo);
        
        //destroy methods call
        context.registerShutdownHook();
        
        
    }
}
