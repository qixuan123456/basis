package Test;

public class bbb {
    public static void main(String[] args) {
        int length = 3;
        int[] nums = {33,144,69};
        System.out.println(findone(length,nums));
    }
    public static int findone(int length,int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(isOne(nums[i])){
                max++;
            }
        }
        return max;
    }
    public static boolean isOne(int num){
        int last = num%10;
        while (num>0){
            if(last<num%10){
                return false;
            }
            last = num%10;
            num = num/10;

        }
        return true;
    }

}
