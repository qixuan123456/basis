package com.qx.shuati.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/9
 * Time: 19:59
 */
public class No794 {

    public static void main(String[] args) {

    }

    public boolean validTicTacToe(String[] board) {

        char[][] b = new char[3][3];
        for (int i = 0; i < 3; i++) {
            b[i] = board[i].toCharArray();
        }
        int hangX = 0; //横向X的数量
        int lieX = 0;  //纵向X的数量
        int hangO = 0;
        int lieO = 0;
        int sumX = 0;   //全部X
        int sumO = 0;   //全部O
        int X = 0;  //玩家1胜利时的有 3 个相同（且非空）的字符填充任何行、列或对角线的个数
        int O = 0;
        //遍历统计
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == 'X') {
                    hangX++;
                    sumX++;
                }
                if (b[j][i] == 'X') {
                    lieX++;
                }
                if (b[i][j] == 'O') {
                    hangO++;
                    sumO++;
                }
                if (b[j][i] == 'O') {
                    lieO++;
                }
            }
            if (hangO == 3 || lieO == 3) {
                O++;
            }
            if (hangX == 3 || lieX == 3) {
                X++;
            }
            hangX = 0;
            lieX = 0;
            hangO = 0;
            lieO = 0;
        }

        //统计斜方向的可能
        for (int i = 0; i < 3; i++) {
            if (b[i][i] == 'X') {
                hangX++;
            }
            if (b[i][2 - i] == 'X') {
                lieX++;
            }
            if (b[i][i] == 'O') {
                hangO++;
            }
            if (b[i][2 - i] == 'O') {
                lieO++;
            }
        }
        if (hangO == 3 || lieO == 3) {
            O++;
        }
        if (hangX == 3 || lieX == 3) {
            X++;
        }
        //X最多可以比O多一个并且不能少于O的数量，1、2不能同时获胜，1获胜时，1获胜时，X一定要大于O的数量
        if ((sumX - sumO) > 1 || (sumX - sumO) < 0 || (O != 0 && X != 0) || (X == 1 && sumX == sumO)) {
            return false;
        }
        //2胜利时 sumX==sumO
        if(O>X&&sumX-sumO!=0){
            return false;
        }
        return true;
    }
}
