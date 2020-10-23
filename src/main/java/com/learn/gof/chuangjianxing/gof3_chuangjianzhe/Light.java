package com.learn.gof.chuangjianxing.gof3_chuangjianzhe;

/**
 * @author yds
 * @title: Light
 * @description: TODO
 * @date 2020/6/4  15:31
 */
public class Light {
    private String postion;
    private String size;

    public Light(String postion, String size) {
        this.postion = postion;
        this.size = size;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
