package com.proxy;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2021/3/16 17:46
 */
public class Test {
    public static void main(String[] args) {
//        JdkProxy jdkProxy = new JdkProxy();//实例化JDKProxy对象
//        UserManager user = (UserManager) jdkProxy.creatInstanceProxy(new UserManagerImpl());//获取代理对象
//        user.addUser("admin", "123123");//执行新增方法


        CglibProxy cglib = new CglibProxy();//实例化CglibProxy对象
        UserManager user2 = (UserManager) cglib.creatInstanceProxy(new UserManagerImpl());//获取代理对象
        user2.delUser("admin");//执行删除方法
    }
}
