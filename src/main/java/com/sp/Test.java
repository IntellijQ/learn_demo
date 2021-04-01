package com.sp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2021/3/1 16:25
 */
public class Test {
    public static void main(String[] args) {


//        AtomicInteger atomicInteger = new AtomicInteger();
//        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(atomicInteger.incrementAndGet());
//
//        AtomicReference<Object> objectAtomicReference = new AtomicReference<>();


//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.setAllowCircularReferences(false);
//        applicationContext.register(Appconfig.class);
//        applicationContext.refresh();


        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicat.xml");
        System.out.println(applicationContext.getBean("x"));
    }
}
