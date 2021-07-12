package Day21.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No36 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> hang = new HashSet<>();
            Set<Character> lie = new HashSet<>();
            Set<Character> juZhen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'&&!hang.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!lie.add(board[j][i])){
                    return false;
                }
                int a = (i/3)*3+j/3;
                int b = (i%3)*3+j%3;
                if(board[a][b]!='.'&&!juZhen.add(board[a][b])){
                    return false;
                }
            }
        }
        return true;
    }
}
