package com.yds.gof.chuangjianxing.gof3_chuangjianzhe;

/**
 * @author yds
 * @title: VehicleMaker
 * @description: TODO
 * @date 2020/6/4  15:47
 */
public class VehicleMaker {

    private VehicleBuilder vehicleBuilder;

    public void setVehicleBuilder(VehicleBuilder vehicleBuilder) {
        this.vehicleBuilder = vehicleBuilder;
    }

    public void make(){
        vehicleBuilder.inintVehicle();
        vehicleBuilder.addWheels();
        vehicleBuilder.addLights();
    }

    public Vehicle getVehicle(){
        return vehicleBuilder.getVehicle();
    }
}
