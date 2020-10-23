package com.yds.gof.chuangjianxing.gof3_chuangjianzhe;


import java.util.List;

/**
 * @author yds
 * @title: Car
 * @description: TODO
 * @date 2020/6/4  15:30
 */
public class Vehicle {
    private List<Light> lights;
    private List<Wheel> wheels;

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }
}
