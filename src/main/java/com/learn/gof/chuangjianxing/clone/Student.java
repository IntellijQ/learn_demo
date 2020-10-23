package com.learn.gof.chuangjianxing.clone;

/**
 * @author yds
 * @title: Student
 * @description: TODO
 * @date 2020/6/4  19:45
 */
public class Student implements Cloneable {
    private String name;
    private int age;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student)super.clone();
        //手动对address属性进行clone，并赋值给新的person对象
        student.address = (Address) address.clone();
        return student;
    }

    public String stringInfo() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
