package com.qx.day22;

/**
 * @author Xuan
 * Date: 2022/3/18
 * Time: 20:10
 */
abstract class Student {
    String name;
    int age;

    public Student(){

    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    void study(){
        System.out.println(name+"在学习");
    }
}
