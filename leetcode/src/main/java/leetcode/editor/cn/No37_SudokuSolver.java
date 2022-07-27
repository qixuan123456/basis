////编写一个程序，通过填充空格来解决数独问题。 
////
//// 数独的解法需 遵循如下规则： 
////
//// 
//// 数字 1-9 在每一行只能出现一次。 
//// 数字 1-9 在每一列只能出现一次。 
//// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
//// 
////
//// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
////
//// 
////
//// 
//// 
//// 
//// 示例 1： 
////
//// 
////输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",
//".
////",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".
//",".
////","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".
//","6
////"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5
//"],[
////".",".",".",".","8",".",".","7","9"]]
////输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4",
//"8
////"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],[
////"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9",
////"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4",
////"5","2","8","6","1","7","9"]]
////解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
////
////
//// 
////
//// 
////
//// 提示： 
////
//// 
//// board.length == 9 
//// board[i].length == 9 
//// board[i][j] 是一位数字或者 '.' 
//// 题目数据 保证 输入数独仅有一个解 
//// 
//// 
//// 
//// 
//// Related Topics 数组 回溯 矩阵 👍 1313 👎 0
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目Id：37;
 * 题目：解数独，sudoku-solver;
 * 日期：2022-07-06 18:43:55
 */

public class No37_SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new No37_SudokuSolver().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] line = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][][] block = new boolean[3][3][9];
        boolean flag = false;
        List<int[]> list = new ArrayList<>();
        public void solveSudoku(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(board[i][j]=='.'){
                        list.add(new int[]{i,j});
                    }else {
                        int num = board[i][j]-'0'-1;
                        line[i][num]=true;
                        column[j][num]=true;
                        block[i/3][j/3][num]=true;
                    }
                }
            }
            dfs(board,0);
        }

        public void dfs(char[][] board,int n){
            if(n==list.size()){
                flag = true;
                return;
            }
            int[] temp = list.get(n);
            for (int i = 0; i < 9&&!flag; i++) {
                if(!line[temp[0]][i]&&!column[temp[1]][i]&&!block[temp[0]/3][temp[1]/3][i]){
                    line[temp[0]][i]=true;
                    column[temp[1]][i]=true;
                    block[temp[0]/3][temp[1]/3][i]=true;
                    board[temp[0]][temp[1]] = (char)(i+1+'0');
                    dfs(board,n+1);
                    if(!flag){
                        board[temp[0]][temp[1]] = '.';
                        line[temp[0]][i]=false;
                        column[temp[1]][i]=false;
                        block[temp[0]/3][temp[1]/3][i]=false;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}