package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author xuan
 * @date 2022/5/14 15:46
 */
public class No79 {

    public boolean[][] flag;
    public char[][] board;
    public String word;
    public int length;
    public int width;
    public int[][] w = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        Random random = new Random();
        for (long i = 0; i < 2000; i++) {
            long nblk = i / 11;
            if (nblk > 0) {
                boolean b = (nblk % 61) > (random.nextLong() % 61);
                nblk = nblk / 61 + (b ? 1 : 0);
            }
            System.out.print(nblk+"\t");
        }
        No79 no79 = new No79();
        char[][] board = {{'A','B','C','E'},
                {'S','F','D','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(no79.exist(board,word));
    }
    public boolean exist(char[][] board, String word) {
        length = board.length;
        width = board[0].length;
        flag = new boolean[length][width];
        this.word = word;
        this.board = board;
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                if(exist(i,j,0)){
                    return true;
                }else{
                    System.out.println("false");
                }
            }
        }
        return false;
    }
    public boolean exist(int x,int y,int index){
        if(x<0||y<0||x>=length||y>=width||flag[x][y]||index>=word.length()||board[x][y]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        flag[x][y] = true;
        for(int i = 0;i<4;i++){
            if(exist(x+w[i][0],y+w[i][1],index+1)){
                return true;
            }
        }
        flag[x][y] = false;
        System.out.println(x+" "+ y);
        return false;
    }
}
