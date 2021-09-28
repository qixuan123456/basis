package day21.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/9/27
 * Time: 19:37
 */
public class NO77 {
    public static void main(String[] args) {
        System.out.println(combine(0,3));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        add(1,lists,new ArrayList<>(),n,k);
        return lists;
    }
    public static void add(int id ,List<List<Integer>> lists,List<Integer>list,int n,int len){
        if(id>n+1){
            return;
        }
        if(list.size()==len){
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(id);
        add(id+1,lists,list,n,len);
        list.remove(list.size()-1);
        add(id+1,lists,list,n,len);
    }
}
