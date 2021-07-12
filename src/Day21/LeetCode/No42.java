package Day21.LeetCode;

public class No42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length -1;
        int leftMax = 0;
        int rightMax = 0;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }
                else{
                    answer = answer + leftMax - height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax = height[right];
                }
                else {
                    answer = answer + rightMax - height[right];
                }
                right--;
            }
        }
        return answer;
    }
}
