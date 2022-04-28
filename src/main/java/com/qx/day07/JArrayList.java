package com.qx.day07;

import java.util.ArrayList;
import java.util.Iterator;

public class JArrayList<E> extends ArrayList<E> {
    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        //sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append("\n").toString();
            sb.append(',').append(' ');
        }
    }
}
