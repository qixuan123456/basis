package com.qx.hash;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test02 {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        Iterator<Integer> iterator = a.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
            iterator.remove();

        }
        Iterator<Integer> iterator2 = a.iterator();
        while(iterator2.hasNext())
        {
            System.out.println("-----------------------");
            System.out.println(iterator2.next());
            System.out.println(iterator2.next());
        }

        System.out.println("------------------------------------------");


    }
}
