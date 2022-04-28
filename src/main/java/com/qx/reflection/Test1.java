package com.qx.reflection;

import java.util.Objects;

/**
 * @author Xuan
 * Date: 2021/11/22
 * Time: 16:27
 */
public class Test1 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        ManUser user = new ManUser();

        Class c1 = user.getClass();
        System.out.println(c1.hashCode());

        Class c2 = Class.forName("main.java.reflection.Test1$ManUser");
        System.out.println(c2.hashCode());

        Class c3 = ManUser.class;
        System.out.println(c3.hashCode());

        Class c4 = c1.getSuperclass();
        System.out.println(c4);

    }

    static class User{
        private String name;
        private int id;
        private int age;

        public User() {
        }

        public User(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id && age == user.age && name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id, age);
        }
    }
    static class ManUser extends User{
        public ManUser(){
            super();
        }
    }
}
