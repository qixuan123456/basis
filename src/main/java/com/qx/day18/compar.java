package com.qx.day18;

import java.util.Comparator;

public class compar implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        long t1 = o1.getAge();
        long t2 = o2.getAge();

        if (t1 < t2) {
            return 1;
        } else if (t1 >= t2) {
            return -1;
        } else {
            return 0;
        }
    }
}
