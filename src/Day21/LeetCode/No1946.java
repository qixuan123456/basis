package Day21.LeetCode;

public class No1946 {
    public static void main(String[] args) {
        String num = "214010";
        int [] change = {6,7,9,7,4,0,3,4,4,7};
        System.out.println(maximumNumber(num,change));
    }
    public static String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i]-'0')<change[chars[i]-'0']){
                chars[i] = (char)(change[chars[i]-'0']+'0');
                flag = false;
                continue;
            } else if((chars[i]-'0')==change[chars[i]-'0']){
                chars[i] = (char)(change[chars[i]-'0']+'0');
                continue;
            }
            if(!flag){
                return new String(chars);
            }
        }
        return new String(chars);
    }
}
