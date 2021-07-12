package Day21.LeetCode;

public class No209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minlength=0;
        int sum = 0;
        while (left<=right&&right<=nums.length){

            if(sum>=target){
                sum -= nums[left];
                if(minlength<right - left + 1){
                    minlength = right - left + 1;
                }
                left++;
            }
            else {
                if(right<nums.length-1){
                    right++;
                    sum += nums[right];
                }
            }
        }
        return minlength;
    }
}
