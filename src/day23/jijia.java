package day23;

public class jijia {
    public static void main(String[] args) {


        int n = 2;
        int m = 2;
        int x = 2;
        int y = 2;
        int[][] nums = {
                {1,2},
                {-1,3}
        };
        String s = "kjljk";
        System.out.println(remove(n,m,x,y,nums,s));
    }
    public static long remove(int n,int m,int x,int y,int[][] nums,String s){
        long res = 0;
        int a=0,b=0;
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)){
                case 'h':
                    if(i!=0&&s.charAt(i-1)!='h'){
                    res+=x;
                }
                    if(b-1<0||nums[a][b-1]==-1){
                    res+=y;
                    break;
                }
                    res+=Math.max(nums[a][b],nums[a][b-1]);
                    b=b-1;
                    break;
                case 'j':
                    if(i!=0&&s.charAt(i-1)!='j'){
                        res+=x;
                    }
                    if(a+1==n||nums[a+1][b]==-1){
                        res+=y;
                        break;
                    }
                    res+=Math.max(nums[a][b],nums[a+1][b]);
                    a=a+1;
                    break;
                case 'k':
                    if(i!=0&&s.charAt(i-1)!='k'){
                        res+=x;
                    }
                    if(a-1<0||nums[a-1][b]==-1){
                        res+=y;
                        break;
                    }
                    res+=Math.max(nums[a][b],nums[a-1][b]);
                    a=a-1;
                    break;
                case 'l':
                    if(i!=0&&s.charAt(i-1)!='l'){
                        res+=x;
                    }
                    if(b+1==m||nums[a][b+1]==-1){
                        res+=y;
                        break;
                    }
                    res+=Math.max(nums[a][b],nums[a][b+1]);
                    b=b+1;
                    break;

            }
        }
        return res;
    }
}
