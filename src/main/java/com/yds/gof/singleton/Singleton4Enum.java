package com.yds.gof.singleton;

import java.util.UUID;

/**
 * @title: Singleton4Enum
 * @description: 枚举单例
 * @author yds
 * @date 2020/5/28 17:43
 */
public enum  Singleton4Enum {
    INSTANCE;
    private String uuid = UUID.randomUUID().toString();
    private String url = "数据库地址";
    private String userName = "数据库用户名";
    private String passward = "数据库密码";

    @Override
    public String toString() {
        return "Singleton4Enum{" +
                "uuid='" + uuid + '\'' +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", passward='" + passward + '\'' +
                '}';
    }
}
