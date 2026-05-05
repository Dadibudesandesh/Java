package com.sgi.com.sgi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
        
        Student stud=(Student) context.getBean("stud1");
        System.out.println(stud.getName());
        System.out.println(stud.getAge());
        System.out.println(stud.getGender());

        
    }
}
