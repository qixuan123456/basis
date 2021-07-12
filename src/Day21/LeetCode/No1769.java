package Day21.LeetCode;

public class No1769 {
    public static void main(String[] args) {
        String boxes = "001011";
        int[] a = minOperations(boxes);
        for (int b:a) {
            System.out.print(b+"\t");

        }
    }
    public static int[] minOperations(String boxes) {
        int[] c=new int[boxes.length()];
        for(int i = 0;i<boxes.length();i++){
            int num=0;
            for(int j=0;j<boxes.length();j++){
                if(boxes.charAt(j)=='1'){
                    num+=Math.abs(i-j);
                }
            }
            c[i]=num;
        }
        return c;
    }
}
