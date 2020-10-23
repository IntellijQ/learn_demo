package com.learn.gof.chuangjianxing.clone;

/**
 * @author yds
 * @title: Address
 * @description: TODO
 * @date 2020/6/4  19:45
 */
public class Address implements Cloneable{
    private String prionce;
    private String city;

    public Address(String prionce, String city) {
        this.prionce = prionce;
        this.city = city;
    }

    public String getPrionce() {
        return prionce;
    }

    public void setPrionce(String prionce) {
        this.prionce = prionce;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "prionce='" + prionce + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
