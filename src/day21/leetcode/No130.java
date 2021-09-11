package day21.leetcode;

import day21.tool.Util;

public class No130 {//[["X","O","X","O","X","O"],["O","X","O","X","O","X"],["X","O","X","O","X","O"],["O","X","O","X","O","X"]]
    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};
        Util.print2Array(board);
        System.out.println("---------------------");
        solve(board);
        Util.print2Array(board);
    }
    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            findZero(board,i,0);
            findZero(board,i, board[i].length-1);
        }
        for (int j = 0; j < board[0].length; j++) {
            findZero(board,0,j);
            findZero(board,board.length-1, j);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'x'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void findZero(char[][] board ,int i,int j){
        if(i<0||j<0||i>=board.length||j>=board[i].length||board[i][j]!='O'){
            return ;
        }
        board[i][j] = 'x';
        findZero(board, i - 1, j);
        findZero(board, i + 1, j);
        findZero(board, i, j - 1);
        findZero(board, i, j + 1);

    }
}
