package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hhh {
    public static void main(String[] args) {
        Integer[] a = {1,2,5,68};
        List<Integer> list = Arrays.asList(a);
        List<List<Integer>> res = get_list(list);
        System.out.println(res);
    }

    public static List<List<Integer>> get_list(List<Integer> list){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        int n = 1;
        for (Integer integer : list) {
            list1.add(integer);
            if (list1.size() >= n) {
                res.add(list1);
                list1 = new ArrayList<>();
                n++;
            }
        }
        return res;
    }
}
