package com.proxy;

/**
 * @author yds
 * @title: UserManager
 * @description: TODO
 * @date 2021/3/16 17:43
 */
public interface UserManager {
    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    void delUser(String userName);
}
