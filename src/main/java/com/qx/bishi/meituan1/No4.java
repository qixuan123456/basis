package com.qx.bishi.meituan1;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class No4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] temp = IntStream.range(0,n).boxed().sorted((a,b)->nums[a]-nums[b]).mapToInt(Integer::intValue).toArray();
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n ; i++) {
            int target = 3*nums[i];
            int l = 0,r = n-1;
            while(l<i&&i<r){
                int sum = nums[l]+nums[r];
                if(sum==target){
                    if(temp[l]<temp[i]&&temp[i]<temp[r]){
                        ans++;
                    }
                    l = l+1;
                    while(l<i&&nums[l]==nums[l-1]){
                        int rr = r-1;
                        while(rr>i&&nums[rr]==nums[r]){
                            if(temp[l]<temp[i]&&temp[i]<temp[rr]){
                                ans++;
                            }
                            rr--;
                        }
                        l++;
                    }
                    r--;
                    while(r>i&&nums[r+1]==nums[r]){
                        r--;
                    }
                }else if(sum<target) {
                    l++;
                }else {
                    r--;
                }

            }
        }
        System.out.println(ans);
    }

}
