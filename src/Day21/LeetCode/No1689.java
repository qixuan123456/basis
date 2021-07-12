package Day21.LeetCode;

public class No1689 {
    public static void main(String[] args) {
        String n = "123";
        int a = minPartitions(n);
        System.out.println(a);
    }
    public static int minPartitions(String n) {
        char max='0';
        for(int i=0;i<n.length();i++){
            if(n.charAt(i)>max){
                max=n.charAt(i);
            }
        }
        return (int)(max-'0');
    }
}
