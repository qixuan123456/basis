package com.qx.day21.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author xuan
 * @date 2022/5/28 19:34
 */
public class No999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sss = null;
        while((sss= br.readLine())!=null){
            String[] s1 = sss.split(" ");
            int N = Integer.parseInt(s1[0]);
            int M = Integer.parseInt(s1[1]);
            int[] student = new int[N];
            String[] ccc = br.readLine().split(" ");
            for(int i=0;i<N;i++){
                student[i] = Integer.parseInt(ccc[i]);
            }
            for(int i=0;i<M;i++){
                String[] s = br.readLine().split(" ");
                char c  = s[0].charAt(0);
                int a = Integer.parseInt(s[1]);
                int b = Integer.parseInt(s[2]);
                if(a>b){
                    int t = a;
                    a = b;
                    b = t;
                }
                if(c == 'Q'){
                    int max = 0;
                    for ( int j = a-1; j <= b-1; j++) {
                        max = Math.max(max,student[j]);
                    }
                    System.out.println(max);
                }else {
                    student[(a-1)] = b;
                }
            }
        }
    }

    public int numRookCaptures(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='R'){
                    for (int k = i-1; k >= 0; k--) {
                        if(board[i][j]=='B'){
                            break;
                        }
                        if(board[i][j]=='p'){
                            ans++;
                        }
                    }
                    for (int k = i+1; k < board.length; k++) {
                        if(board[i][j]=='B'){
                            break;
                        }
                        if(board[i][j]=='p'){
                            ans++;
                        }
                    }
                    for (int k = j-1; k >= 0; k--) {
                        if(board[i][j]=='B'){
                            break;
                        }
                        if(board[i][j]=='p'){
                            ans++;
                        }
                    }
                    for (int k = j+1; k < board[i].length; k++) {
                        if(board[i][j]=='B'){
                            break;
                        }
                        if(board[i][j]=='p'){
                            ans++;
                        }
                    }
                    return ans;
                }
            }
        }
        return ans;
    }
}
