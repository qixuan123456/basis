package Day21.LeetCode;

public class No1822 {
    public static void main(String[] args) {
        int[] nums={-1,-2,-3,-4,3,2,1};
        System.out.println(arraySign(nums));
    }
    public static int arraySign(int[] nums) {
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                return 0;
            }
            if(nums[i]<0){
                a++;
            }
        }
        if(a%2==0){
            return 1;
        }
        if(a%2==1){
            return -1;
        }
        return 0;
    }
}
