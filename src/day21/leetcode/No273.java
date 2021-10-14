package day21.leetcode;

/**
 * User: xuan
 * Date: 2021/10/11
 * Time: 11:18
 */
public class No273 {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {" ", " Thousand ", " Million ", " Billion "};
    public static void main(String[] args) {
        int nums = 20;
        No273 no273 = new No273();
        System.out.println(no273.numberToWords(nums));
    }


    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int cur = num%1000;
        for (int i = 0; i < 4; i++) {
            sb.insert(0,number3ToWords(cur,i));
            num = num/1000;
            cur = num%1000;
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    public String number3ToWords(int num,int flag){
        if(num ==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int a;
        a = num%100;
        if(num/100!=0){
            sb.append(singles[num/100])
                    .append(" Hundred");
            if(a!=0){
                sb.append(" ");
            }
        }

        if(a<10){
            sb.append(singles[a]);
        }else if(a>=20){
            sb.append(tens[a/10]);
            if(a%10!=0){
                sb.append(" ").append(singles[a%10]);
            }
        }else {
            sb.append(teens[a%10]);
        }
        sb.append(thousands[flag]);
        return sb.toString();
    }
}
