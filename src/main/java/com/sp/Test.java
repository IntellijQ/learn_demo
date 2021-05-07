package com.sp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

//
        Object o = new Object();
        System.out.println(o.hashCode());
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicat.xml");
        X x = (X)applicationContext.getBean("x");
        System.out.println(x);
        x.test();
        System.out.println(x);


//        String path = "999999";
//        int i = path.lastIndexOf('/');
//        System.out.println(i);
//        System.out.println(path.substring(0, i));
    }
}
