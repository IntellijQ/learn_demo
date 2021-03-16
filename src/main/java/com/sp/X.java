package com.sp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;

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
public class X implements InitializingBean /* BeanNameAware,  , BeanClassLoaderAware*/{
//
//    Y y;
//
//    public Y getY() {
//        return y;
//    }
//
//    public void setY(Y y) {
//        this.y = y;
//    }

    private String myXName;

    public X(){
        System.out.println("X create");
    }

    public String getMyXName() {
        return myXName;
    }

    public void setMyXName(String myXName) {
        System.out.println("属性填充" + myXName);
        this.myXName = myXName;
    }
    //    @Override
//    public void setBeanName(String name) {
//        this.myXName = name;
//        System.out.println("set aware...");
//    }
//
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean...");
    }
//
//    private ClassLoader classLoader;
//    @Override
//    public void setBeanClassLoader(ClassLoader classLoader) {
//        System.out.println("classLoader.." + classLoader);
//    }
}
