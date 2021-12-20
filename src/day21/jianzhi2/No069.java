package day21.jianzhi2;

/**
 * User: xuan
 * Date: 2021/10/14
 * Time: 20:01
 */
public class No069 {
    public static void main(String[] args) {
        No069 no069 = new No069();
        int[] arr = {1,4,3};
        System.out.println(no069.peakIndexInMountainArray(arr));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int left =0,right = arr.length-1;
        int in = (left+right)/2;
        while(left<=right){
            in = (left+right)/2;
            if(arr[in]<arr[in+1]){
                left = in;continue;
            }
            if(arr[in]<arr[in-1]){
                right = in;continue;
            }
            return in;
        }
        return in;
    }
}
