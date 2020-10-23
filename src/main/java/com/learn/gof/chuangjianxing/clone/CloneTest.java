package com.learn.gof.chuangjianxing.clone;

/**
 * @author yds
 * @title: CloneTest
 * @description: TODO
 * @date 2020/6/4  19:47
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student= new Student("yds", 28,new Address("四川", "天府二街"));
        Student cloneStudent = (Student)student.clone();


        System.out.println(student);
        System.out.println(cloneStudent);

        cloneStudent.setName("yds_clone");
        Address address = cloneStudent.getAddress();
        address.setPrionce("四川_clone");
        System.out.println(student.stringInfo());
        System.out.println(cloneStudent.stringInfo());
    }
}
