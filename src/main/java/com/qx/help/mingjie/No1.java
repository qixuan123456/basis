package com.qx.help.mingjie;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/31 15:17
 */
public class No1 {

    static int N;
    static Map<Integer,List<Integer>> map;
    static int[] nums ;
    static int maxSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxSum = Integer.MIN_VALUE;
        N = sc.nextInt();
        nums = new int[N+1];
        map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            List<Integer> orDefault = map.getOrDefault(a, new ArrayList<>());
            orDefault.add(i);
            map.put(a,orDefault);
        }
        maxPathSum(map.get(0).get(0));
        System.out.println(maxSum);
    }

    public static void maxPathSum(int index) {
        maxGain(index);
    }

    public static int maxGain(int index) {
        if (index>N) {
            return 0;
        }
        List<Integer> list = map.get(index);

        int leftGain = 0;
        int rightGain = 0;
        if(list!=null&&list.size()>0){
            leftGain = Math.max(maxGain(list.get(0)), 0);
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        if(list!=null&&list.size()>1){
            rightGain = Math.max(maxGain(list.get(1)), 0);
        }
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = nums[index] + leftGain + rightGain;
        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);
        // 返回节点的最大贡献值
        return nums[index] + Math.max(leftGain, rightGain);
    }
}
