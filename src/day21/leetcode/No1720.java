package day21.leetcode;

public class No1720 {
    public static void main(String[] args) {
        int[] encoded = {1,2,3};
        int[] arr = decode(encoded,1);
        for (int a :
                arr) {
            System.out.print(a+" ");
        }
    }
    public static int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0]=first;
        for(int i = 1;i<encoded.length+1;i++){
            arr[i]=arr[i-1]^encoded[i-1];
        }
        return arr;
    }
}
