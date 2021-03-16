package com.learn.jvm.jdk8;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yds
 * @title: DefinClassLoader
 * @description: 自定义类加载器
 * @date 2021/1/5 17:40
 */
public class DefinClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
        InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
        if(resourceAsStream == null){
            return super.loadClass(name);
        }
        try {
            byte[] bytes = new byte[resourceAsStream.available()];
            resourceAsStream.read(bytes);
            return  defineClass(name,bytes,0,bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }
}
