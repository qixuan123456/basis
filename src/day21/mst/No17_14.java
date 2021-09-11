package day21.mst;
//错误 超时
public class No17_14 {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,2,4,6,8};
        int k=4;
        int[] aa=smallestK(arr,k);
        for (int a :
                aa) {
            System.out.print(a+"\t");
        }
    }
    public static int[] smallestK(int[] arr, int k) {
        int a;
        if(k>arr.length){
            k=arr.length;
        }
        for(int i=0;i<k;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    a=arr[i];
                    arr[i]=arr[j];
                    arr[j]=a;
                }
            }
        }
        int[] aa=new int[k];
        for(int i=0;i<k;i++){
            aa[i]=arr[i];
        }
        return aa;
    }
}
