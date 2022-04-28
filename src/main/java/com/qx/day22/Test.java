package com.qx.day22;

/**
 * @author Xuan
 * Date: 2022/3/18
 * Time: 20:07
 */
public class Test {
    public static void main(String[] args) {
        User user = new UserImpl();
        user.study();

        GaoStudent student1 = new GaoStudent("qwe",10);
        ((Student)student1).study();
        student1.eat();
    }
}
