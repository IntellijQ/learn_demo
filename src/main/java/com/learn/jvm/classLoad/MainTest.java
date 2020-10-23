package com.learn.jvm.classLoad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yds
 * @title: MainTest
 * @description: TODO
 * @date 2020/5/2113:58
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(SubClass.age);
//        SuperClass[] superClasses = new SuperClass[1];
//        System.out.println(SuperClass.SEX);
//        System.out.println(InterfaceClass.name);


        List<Person> msgList = new ArrayList<>();
        msgList.add(new Person("1",new Date()));
        Thread.sleep(1000);
        msgList.add(new Person("2",new Date()));
        Thread.sleep(1000);
        msgList.add(new Person("3",new Date()));
        Thread.sleep(1000);
        msgList.add(new Person("4",new Date()));
        Thread.sleep(1000);
        msgList.add(new Person("5",new Date()));
        Thread.sleep(1000);
        msgList.add(new Person("5",new Date(2020,12,12,12,12,12)));
        msgList.sort((Person m1, Person m2) -> m2.getCre().compareTo(m1.getCre()));

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("ddd");
        for(Person person : msgList){
            System.out.println(person);

        }
    }


   static class Person{
        String id;
        Date cre;

        public Person(String id, Date cre) {
            this.id = id;
            this.cre = cre;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getCre() {
            return cre;
        }

        public void setCre(Date cre) {
            this.cre = cre;
        }

       @Override
       public String toString() {
           return "Person{" +
                   "id='" + id + '\'' +
                   ", cre=" + cre +
                   '}';
       }
   }
}
