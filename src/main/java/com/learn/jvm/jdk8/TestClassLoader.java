package com.learn.jvm.jdk8;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author yds
 * @title: TestLoadTwoClass
 * @description: TODO
 * @date 2020/12/21 18:24
 */
public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//对于用户自定义类 使用的加载器 是应用程序加载器 sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);//sun.misc.Launcher$ExtClassLoader@3f91beef

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);//null ? 为什么是null   对于jAVA的核心类库都是 使用的加载器 是 启动类加载器


        ClassLoader classLoader1 = TestClassLoader.class.getClassLoader();
        System.out.println("获取当前类的类加载器：" + classLoader1);//sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println("String类的类加载器：" + classLoader2);//null




        // 获取类加载器负责的路径
        getClassLoaderPath();


        // 用户自定义类加载器
        userDefinClassLoader();


//        Class.forName("");
    }

    private static void userDefinClassLoader() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        DefinClassLoader classLoader = new DefinClassLoader();
        Object o = classLoader.loadClass("com.learn.jvm.jdk8.TestConstantPool").newInstance();
        System.out.println(o.getClass().getClassLoader());

        System.out.println(o instanceof TestConstantPool);
    }


    public static void getClassLoaderPath(){
        System.out.println("启动类加载器");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }


        System.out.println("扩展类加载器");
        String getenv = System.getProperty("java.ext.dirs");
        for (String path : getenv.split(";")){
            System.out.println(path);
        }
    }
}
