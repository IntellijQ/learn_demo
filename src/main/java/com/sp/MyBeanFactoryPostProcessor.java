//package com.sp;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//
///**
// * @author yds
// * @title: MyBeanFactoryPostProcessor
// * @description: TODO
// * @date 2021/3/12 17:07
// */
//public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.out.println("BeanFactoryPostProcessor....");
//        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        for (int i = 0; i < beanDefinitionNames.length; i++) {
//            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionNames[i]);
//            System.out.println("BeanFactoryPostProcessor 查询BeanDefinition信息：" + beanDefinition);
//        }
//    }
//
//    public MyBeanFactoryPostProcessor(){
//        System.out.println("MyBeanFactoryPostProcessor...");
//    }
//}
