package com.yds.gof.chuangjianxing.gof3_chuangjianzhe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: BikeCarBuilder
 * @description: TODO
 * @date 2020/6/4  15:36
 */
public class BikeBuilder extends VehicleBuilder {
    @Override
    public void addLights() {
        Light lightFront = new Light("前","20");
        Light lightBehind  = new Light("后","30");
        List<Light> lights = new ArrayList<>();
        lights.add(lightFront);
        lights.add(lightBehind);
        vehicle.setLights(lights);
    }

    @Override
    public void addWheels() {
        Wheel wheelFront = new Wheel("前","20");
        Wheel wheelBehind  = new Wheel("后","30");
        List<Wheel> Wheels = new ArrayList<>();
        Wheels.add(wheelFront);
        Wheels.add(wheelBehind);
        vehicle.setWheels(Wheels);
    }
}
