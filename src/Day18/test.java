package Day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("tom", 18));
        list.add(new Student("jack", 20));
        list.add(new Student("rose", 15));
        list.add(new Student("jerry", 17));
        System.out.println("排序前:");
        for (Student o : list) {
            System.out.println(o);

        }
        Collections.sort(list,new compar());

        for (Student o : list) {
            System.out.println(o);

        }



    }
}

