package day21.leetcode;

public class No11 {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }



    public static int maxArea(int[] height){
        int max=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            max = height[i]<height[j]? Math.max(max,(j-i)*height[i++]):Math.max(max,(j-i)*height[j--]);
        }
        return max;
    }
}
