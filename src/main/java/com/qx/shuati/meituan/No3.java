package com.qx.shuati.meituan;

import java.util.*;

/**
 * @author Xuan
 * Date: 2021/12/20
 * Time: 20:07
 */
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i+1,scanner.nextInt()+scanner.nextInt()*2);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] res = new int[m];
        for (int j = 0; j < m; j++) {
            res[j] = list.get(j).getKey();
        }
        Arrays.sort(res);

        for (int j = 0; j < m-1; j++) {
            System.out.print(res[j]+" ");
        }
        System.out.print(res[m-1]);
    }


}
