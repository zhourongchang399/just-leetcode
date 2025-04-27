//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
// 
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
// 
// 
// 
// 
//
//
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
//
// Related Topics 数组 哈希表 回溯 矩阵 👍 1927 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 模拟，先初始化，行列和九宫格的 used 二维数组；
 *               在递归遍历每一个位置是否有 [1,9] 满足三个条件；
 *               满足则更新三个条件二维数组和 board 并继续下一个子递归；
 *               不满足则回溯到上一子递归，并搜索下一个满足的值；
 *               直到 board 中不存在未知值。
 * @date: 2025/4/27 16:26
 * @param null
 * @return
 */
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                rows[i][board[i][j] - '0'] = true;
                cols[j][board[i][j] - '0'] = true;
                boxes[(i / 3) * 3 + j / 3][board[i][j] - '0'] = true;
            }
        }
        mySolveSudoku(board, rows, cols, boxes);
    }

    private boolean mySolveSudoku(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (!rows[i][k] && !cols[j][k] && !boxes[(i / 3) * 3 + j / 3][k]) {
                            board[i][j] = (char) ('0' + k);
                            rows[i][k] = true;
                            cols[j][k] = true;
                            boxes[(i / 3) * 3 + j / 3][k] = true;
                            if (mySolveSudoku(board, rows, cols, boxes)) {
                                return true;
                            }
                            board[i][j] = '.';
                            rows[i][k] = false;
                            cols[j][k] = false;
                            boxes[(i / 3) * 3 + j / 3][k] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
