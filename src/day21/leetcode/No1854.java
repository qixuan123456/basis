package day21.leetcode;


public class No1854 {
    public static void main(String[] args) {
        int[][] logs = {{1950,1961},{1960,1971},{1970,1981}};
        int a = maximumPopulation(logs);
        System.out.println(a);
    }
    public static int maximumPopulation(int[][] logs) {
        int[] nums = new int[101];
        int max = 0;
        int maxi=0;
        for (int i = 0; i < logs.length; i++) {
            for(int j = logs[i][0];j<logs[i][1];j++){
                nums[j-1950]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max=nums[i];
                maxi=i;
            }
        }

        return maxi+1950;
    }
}
