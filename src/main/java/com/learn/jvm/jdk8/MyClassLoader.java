package com.learn.jvm.jdk8;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author yds
 * @title: MyClassLoader
 * @description: 自定义ClassLoader
 * @date 2021/1/6 15:58
 */
public class MyClassLoader extends ClassLoader {
    private String byteCodePath;

    public MyClassLoader(String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        String fileName = byteCodePath + className + ".class";
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
            int len;
            byte[] date = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = bis.read(date)) != -1) {
                baos.write(date, 0, len);
            }
            byte[] byteCodes = baos.toByteArray();
            return defineClass(byteCodes, 0, byteCodes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(className);
    }
}
