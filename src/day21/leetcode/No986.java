package day21.leetcode;


import day21.tool.Util;

public class No986 {
    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] a = intervalIntersection(firstList,secondList);
        Util.print2Array(a);
    }
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        int z = 0;
        int l1 = firstList.length;
        int l2 = secondList.length;
        int[][] aws = new int[l1+l2][2];
        while(i<l1&&j<l2){
            if(firstList[i][1]<secondList[j][0]){
                i++;
            }else if(firstList[i][0]>secondList[j][1]){
                j++;
            }else {
                aws[z][0] = Math.max(firstList[i][0],secondList[j][0]);
                aws[z][1] = Math.min(firstList[i][1],secondList[j][1]);
                z++;
                if(firstList[i][1]<secondList[j][1]){
                    i++;
                }
                else {
                    j++;
                }
            }
        }
        int[][] a = new int[z][2];
        System.arraycopy(aws,0,a,0,z);
        return a;
    }
}
