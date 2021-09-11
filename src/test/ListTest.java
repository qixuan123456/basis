package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(2);
        Map<Integer,Integer> map = new HashMap<>(2);
        map.put(0,0);list.add(0);
        map.put(1,1);list.add(5);
        map.put(2,2);list.add(6);
        map.put(3,3);list.add(7);
        list.remove(new Integer(7));
    }
}
