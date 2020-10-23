package com.yds.gof.chuangjianxing.gof3_chuangjianzhe;

/**
 * @author yds
 * @title: CarBuilder
 * @description: TODO
 * @date 2020/6/4  15:33
 */
public abstract class VehicleBuilder {
    Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void inintVehicle(){
        vehicle = new Vehicle();
    }

    public abstract void addLights();
    public abstract void addWheels();
}
