package day21.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/1
 * Time: 20:53
 */
public class No2087 {
    public static void main(String[] args) {

    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int res = 0;
        while(startPos[0]!=homePos[0]){
            if(startPos[0]<homePos[0]){
                startPos[0]++;
            }else {
                startPos[0]--;
            }
            res+=rowCosts[startPos[0]];
        }

        while(startPos[1]!=homePos[1]){
            if(startPos[1]<homePos[1]){
                startPos[1]++;
            }else {
                startPos[1]--;
            }
            res+=colCosts[startPos[1]];
        }
        return res;
    }
}
