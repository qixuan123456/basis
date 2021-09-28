package day21.leetcode;

/**
 * User: xuan
 * Date: 2021/9/25
 * Time: 12:03
 */
public class No2011 {

    public static void main(String[] args) {
        String[] operations = {"X++","++X","--X","X--"};
        System.out.println(finalValueAfterOperations(operations));
    }
    public static int finalValueAfterOperations(String[] operations) {
        int x= 0;
        for (String operation : operations) {
            switch (operation) {
                case "--X":
                case "X--":
                    x--;
                    break;
                case "++X":
                case "X++":
                    x++;
                    break;
            }
        }
        return x;
    }

}
