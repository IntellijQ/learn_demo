package com.yds.gof.chuangjianxing.gof3_chuangjianzhe;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/6/4  15:52
 */
public class Test {
    public static void main(String[] args) {
        BikeBuilder bikeBuilder = new BikeBuilder();
        VehicleMaker vehicleMaker = new VehicleMaker();
        vehicleMaker.setVehicleBuilder(bikeBuilder);
        vehicleMaker.make();
        Vehicle vehicle = vehicleMaker.getVehicle();
        System.out.println(vehicle.getLights().size());
        System.out.println(vehicle.getWheels().size());
        Object o = new Object();
    }
}
