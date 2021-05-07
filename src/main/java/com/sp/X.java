package com.sp;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author yds
 * @title: X
 * @description: 初始化回调
 * 优先级：
 * 1.使用@PostConstruct
 * 2.实现InitializingBean  重写afterPropertiesSet方法
 * 3.<bean id="exampleInitBean" class="examples.ExampleBean" init-method="init"/>
 * @date 2021/3/1 16:23
 */
public class X  /* implements InitializingBean, BeanNameAware, BeanClassLoaderAware */{

////    @Autowired
//    private Y y;
//
//    public Y getY() {
//        return y;
//    }
//
//    public void setY(Y y) {
//        System.out.println("X属性填充，设置Y=" + y);
//        this.y = y;
//    }

    private String myXName;

    public X() {
        System.out.println("实例化 X create");
    }

    public X(String myName) {
        this.myXName = myName;
    }

    public String getMyXName() {
        return myXName;
    }

    public void setMyXName(String myXName) {
        System.out.println("X属性填充, myXName = " + myXName);
        this.myXName = myXName;
    }
    public void myInit() {
        System.out.println("X myInit...");
    }


    public void test(){
        System.out.println("test..");
    }

//    String beanName;
//    @Override
//    public void setBeanName(String beanName) {
//        this.beanName = beanName;
//        System.out.println("set aware..." + beanName);
//    }
//
//    @PostConstruct
//    public void myPostConstruct() {
//        System.out.println("myPostConstruct...");
//    }
//
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("InitializingBean...");
//    }
//
//
//
//
//    ClassLoader classLoader;
//    @Override
//    public void setBeanClassLoader(ClassLoader classLoader) {
//        this.classLoader = classLoader;
//        System.out.println("classLoader.." + classLoader);
//    }







//    Y y;
//
//    public Y getY() {
//        return y;
//    }
//
//    public void setY(Y y) {
//        this.y = y;
//    }
}
